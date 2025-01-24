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
            // Récupérer les articles via un API Web
            articles.value = ArticleService.ArticleApi.articleService.getArticles();

            // Fermer la popup de chargement
            AppDialogHelpers.get().closeDialog();
        }
    }

}