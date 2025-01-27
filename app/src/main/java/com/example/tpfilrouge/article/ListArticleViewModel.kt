package com.example.tpfilrouge.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoandroid.demoapi.ArticleService
import com.example.tpfilrouge.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListArticleViewModel : ViewModel() {

    var articles = MutableStateFlow<List<Article>>(listOf());

    fun addArticle(article: Article){
        articles.value = articles.value + article;
    }

    fun callArticlesApi(){
        // Afficher la popup de chargement
        AppDialogHelpers.get().showDialog("Chargement des articles en cours")

        viewModelScope.launch {
            // Récupérer le metier listArticle via un API Web
            val serviceResponse = ArticleService.ArticleApi.articleService.getArticles();

            // Plus tard il sera possible de tester le code métier
            /*
            if (serviceResponse.code.equals("200")) {

            }
            */

            // La liste des articles ecoutables se met à jour par rapport à la
            // la liste des articles dans le data
            // Node : on remaque !! aprés data car data est nullable (!! que si nullable))
            articles.value = serviceResponse.data!!;

            // Fermer la popup de chargement
            AppDialogHelpers.get().closeDialog();
        }
    }

}