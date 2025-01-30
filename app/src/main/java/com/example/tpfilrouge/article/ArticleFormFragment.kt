package com.example.tpfilrouge.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniButton
import com.example.tpfilrouge.ui.theme.EniPage
import com.example.tpfilrouge.ui.theme.EniTextField
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ArticleForm(viewModel: ListArticleViewModel, navController : NavController?=null){
    var titleFieldState by remember { mutableStateOf("Un article") }
    var descFieldState by remember { mutableStateOf("Une description") }

    Column {
        EniTextField(label = "Saisir un Email", value = titleFieldState,
            onValueChange = { newValue -> titleFieldState = newValue })
        EniTextField(label = "Saisir une Description", value = descFieldState,
            onValueChange = { newValue -> descFieldState = newValue })
        EniButton("Ajouter") {
            // Instancer un article avec les infos de la saisie
            val newArticle = Article(titleFieldState, descFieldState,
                "https://avatar.iran.liara.run/public");
            // Envoyer l'article via une méthode view model
            viewModel.addArticle(newArticle, onSuccess = {
                navController!!.navigate("list_article")
            })
        }
    }
}

@Composable
fun ArticleEditForm(viewModel: ListArticleViewModel, navController : NavController?=null){
    var titleFieldState by remember { mutableStateOf(viewModel.editedArticle.title) }
    var descFieldState by remember { mutableStateOf(viewModel.editedArticle.desc) }

    Column {
        EniTextField(label = "Saisir un Email", value = titleFieldState,
            onValueChange = { newValue -> titleFieldState = newValue })
        EniTextField(label = "Saisir une Description", value = descFieldState,
            onValueChange = { newValue -> descFieldState = newValue })
        EniButton("Editer") {
            // Instancer un article avec les infos de la saisie
            val editedArticle = Article(titleFieldState, descFieldState,
                "https://avatar.iran.liara.run/public", id = viewModel.editedArticleId);
            // Envoyer l'article via une méthode view model
            viewModel.editArticle(editedArticle)
        }
    }
}

@Composable
fun AddArticleFormPage(viewModel: ListArticleViewModel, navController : NavController?=null){
    Text(text = "Ajouter un article",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = TextStyle(color = Color.White, fontSize = 28.sp)
    )
    ArticleForm(viewModel, navController)
}

@Composable
fun EditArticleFormPage(viewModel: ListArticleViewModel, navController : NavController?=null){
    Text(text = "Modifier un article",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = TextStyle(color = Color.White, fontSize = 28.sp)
    )
    ArticleEditForm(viewModel, navController)
}

@Composable
fun ArticleFormFragmentPage(viewModel: ListArticleViewModel, navController : NavController?=null) {
    // Savoir si je suis en mode edition ou ajout
    val isEdit by viewModel.isEdit.collectAsState();

    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)
        ) {
            if (isEdit){
                EditArticleFormPage(viewModel, navController)
            }
            else {
                AddArticleFormPage(viewModel, navController)
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun ArticleFormFragmentPreview() {
    var viewModel = ListArticleViewModel();
    viewModel.articles = MutableStateFlow(listOf(
        Article("Teletubies", "Meilleur série du monde", "https://avatar.iran.liara.run/public"),
        Article("Velocipastor", "Meilleur film du monde, gros budget", "https://avatar.iran.liara.run/public"),
        Article("Photo mouton béret paille ?", "Pourquoi", "https://avatar.iran.liara.run/public")
    ));
    ArticleFormFragmentPage(viewModel)
}