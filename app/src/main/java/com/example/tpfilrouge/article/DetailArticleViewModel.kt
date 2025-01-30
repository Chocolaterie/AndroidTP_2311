package com.example.tpfilrouge.article

import kotlinx.coroutines.flow.MutableStateFlow

class DetailArticleViewModel {

    var article = MutableStateFlow<Article>(Article("", "", ""));

}