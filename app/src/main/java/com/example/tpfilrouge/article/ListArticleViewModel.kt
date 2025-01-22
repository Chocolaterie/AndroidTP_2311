package com.example.tpfilrouge.article

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ListArticleViewModel : ViewModel() {

    var articles = MutableStateFlow(listOf(
        Article("Teletubies", "Meilleur série du monde", "https://avatar.iran.liara.run/public"),
        Article("Velocipastor", "Meilleur film du monde, gros budget", "https://avatar.iran.liara.run/public"),
        Article("Photo mouton béret paille ?", "Pourquoi", "https://avatar.iran.liara.run/public")
    ));

    fun addArticle(article: Article){
        articles.value = articles.value + article;
    }

}