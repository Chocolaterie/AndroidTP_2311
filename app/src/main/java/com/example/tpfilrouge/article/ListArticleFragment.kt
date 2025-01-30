package com.example.tpfilrouge.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniButton
import com.example.tpfilrouge.ui.theme.EniPage
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ArticleCard(article: Article, viewModel: ListArticleViewModel, detailViewModel: DetailArticleViewModel, navController: NavController?=null){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp)
    ) {
        Box(Modifier.background(brush = Brush.linearGradient(listOf(
            Color(0xFF3a3b5d),
            Color(0xFF535479),
        ))).fillMaxSize()) {
            Row(modifier = Modifier.padding(10.dp)) {
                AsyncImage(
                    model = article.imgPath,
                    contentDescription = "",
                    modifier = Modifier.width(82.dp).padding(horizontal = 5.dp),
                    placeholder = painterResource(R.drawable.reset_password_ic),
                )
                Column(modifier = Modifier.padding(start = 5.dp)) {
                    Text(article.title,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.White))
                    Text(article.desc, style = TextStyle(color = Color.White))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        IconButton(onClick = {

                            detailViewModel.article.value = article;
                            navController!!.navigate("article_detail");

                        }) {
                            Icon(imageVector = Icons.Filled.Info, tint = Color.White, contentDescription = "Voir")
                        }
                        IconButton(onClick = {
                            // Dire au viewmodel qu'on va être en mode édition
                            viewModel.isEdit.value = true;
                            // Dire au viewmodel quel article on va modifier
                            viewModel.editedArticle = article;
                            // Dire au viewmodel quel Id d'article en cours de proccessus
                            viewModel.editedArticleId = article.id;
                            // naviguer dans le formulaire
                            navController!!.navigate("article_form")
                        }) {
                            Icon(imageVector = Icons.Filled.Edit, tint = Color.White, contentDescription = "Edit")
                        }
                        IconButton(onClick = {
                            viewModel.callDeleteArticleApi(article.id);
                        }) {
                            Icon(imageVector = Icons.Filled.Delete, tint = Color.White, contentDescription = "Delete")
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun ListArticleFragmentPage(viewModel: ListArticleViewModel, detailViewModel: DetailArticleViewModel, navController: NavController? = null) {
    // Ecouter les changements de la liste d'article dans le ViewModel
    val articlesState by viewModel.articles.collectAsState();

    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)
        ) {
            Text(text = stringResource(R.string.title_list_article_page),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White, fontSize = 28.sp))
            EniButton("Ajouter un Article") {
                // Passer le edit à false pour revenir en mode ajout dans le form
                viewModel.isEdit.value = false;

                navController!!.navigate("article_form")
            }
            EniButton("Rafraichir") {
                // Appeler l'api du viewmodel
                viewModel.callArticlesApi()
            }
            LazyColumn {
                items(articlesState) { article ->
                    ArticleCard(article, viewModel, detailViewModel, navController)
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun ListArticleActivityPreview() {
    var viewModel = ListArticleViewModel();
    var detailViewModel = DetailArticleViewModel();
    viewModel.articles = MutableStateFlow(listOf(
        Article("Teletubies", "Meilleur série du monde", "https://avatar.iran.liara.run/public"),
        Article("Velocipastor", "Meilleur film du monde, gros budget", "https://avatar.iran.liara.run/public"),
        Article("Photo mouton béret paille ?", "Pourquoi", "https://avatar.iran.liara.run/public")
    ));
    ListArticleFragmentPage(viewModel, detailViewModel)
}