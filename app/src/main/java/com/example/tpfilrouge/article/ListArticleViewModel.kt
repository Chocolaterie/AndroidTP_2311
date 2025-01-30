package com.example.tpfilrouge.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.demoapi.ArticleService
import com.example.tpfilrouge.helpers.AlertDialogHelpers
import com.example.tpfilrouge.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListArticleViewModel : ViewModel() {

    // Indicateur pour savoir si je modifie ou pas un article
    var editedArticleId : String = ""; // Quel est l'article que je modifie
    var editedArticle : Article = Article("", "", ""); // Article en cours d'edition
    var isEdit = MutableStateFlow(false); // Est-ce que je suis en mode edition ?

    var articles = MutableStateFlow<List<Article>>(listOf());

    fun editArticle(article: Article){
        AppDialogHelpers.get().showDialog("Modification de l'article en cours...");

        viewModelScope.launch {
            // Appel api async
            val responseService = ArticleService.ArticleApi.articleService.saveArticle(article);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            // Si ajout ok
            if (responseService.code.equals("200")){
                AlertDialogHelpers.get().show(responseService.message, onClose = {})
            }
            else{
                // Erreur
                AlertDialogHelpers.get().show(responseService.message, onClose = {})
            }
        }
    }

    fun addArticle(article: Article, onSuccess: () -> Unit){
        AppDialogHelpers.get().showDialog("Ajout d'article en cours...");

        viewModelScope.launch {
            // Appel api async
            val responseService = ArticleService.ArticleApi.articleService.saveArticle(article);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            // Si ajout ok
            if (responseService.code.equals("200")){
                AlertDialogHelpers.get().show(responseService.message, onClose = {
                    // Naviguer sur la page liste article
                    onSuccess()
                })
            }
            else{
                // Erreur
                AlertDialogHelpers.get().show(responseService.message, onClose = {})
            }
        }
    }

    fun callArticlesApi(){
        // Afficher la popup de chargement
        AppDialogHelpers.get().showDialog("Chargement des articles en cours")

        viewModelScope.launch {
            // Récupérer le metier listArticle via un API Web
            val serviceResponse = ArticleService.ArticleApi.articleService.getArticles();

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            articles.value = serviceResponse.data!!;

        }
    }

    fun callDeleteArticleApi(id : String){
        AppDialogHelpers.get().showDialog("Suppression de l'article en cours...");

        viewModelScope.launch {
            // Appel api async
            val responseService = ArticleService.ArticleApi.articleService.delete(id);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            // Si suppression ok
            if (responseService.code.equals("200")){

                // Methode 1 : (Le flemmard) Appeler le refresh
                // Avantage : Si d'autres user ont supprimés des articles entre temps, on a plus les articles
                // supprimés par les autres users à l'écran
                // Inconvenients : Moins performant niveau ressource du tel car on on refresh tout l'ecran et en plus on rappel une API
                //callArticlesApi();

                // Methode 2 : Je supprime dans le articles.value l'article je viens de supprimer
                // Inconvenients : Si d'autres user ont supprimés des articles entre temps, on a encore les articles
                // supprimés par les autres users à l'écran
                // Avantage : Plus performant niveau ressource du tel car on fait le strict minimum pour refresh l'ecran
                // EXEMPLE : Supprimer un element de la liste directement
                val newArticles = articles.value.filterNot { it.id == id }
                articles.value = newArticles;

                AlertDialogHelpers.get().show(responseService.message, onClose = {
                })
            }
            else{
                // Erreur
                AlertDialogHelpers.get().show(responseService.message, onClose = {})
            }
        }
    }

}