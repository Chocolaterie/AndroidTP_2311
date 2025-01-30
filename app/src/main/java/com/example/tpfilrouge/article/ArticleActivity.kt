package com.example.tpfilrouge.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class ArticleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleActivityPage()
        }
    }
}

@Composable
fun ArticleActivityPage() {
    val navController = rememberNavController();

    var viewModel = ListArticleViewModel();
    var detailViewModel = DetailArticleViewModel();

    NavHost(
        navController = navController,
        startDestination = "list_article"
    ) {
        composable("list_article") { ListArticleFragmentPage(viewModel, detailViewModel, navController) }
        composable("article_form") { ArticleFormFragmentPage(viewModel, navController) }
        composable("article_detail") { DetailArticleFragmentPage(detailViewModel) }
    }
}

@Preview(
    showBackground = true,
    locale = "en"
)
@Composable
fun ActivityActivityPreview() {
    ArticleActivityPage()
}