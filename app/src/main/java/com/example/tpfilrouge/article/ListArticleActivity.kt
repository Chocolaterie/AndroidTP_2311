package com.example.tpfilrouge.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniPage

class ListArticleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListArticleActivityPage()
        }
    }
}

@Composable
fun ListArticleActivityPage() {
    var articles = listOf(
      Article("Teletubies", "Meilleur série du monde", "https://avatar.iran.liara.run/public"),
      Article("Velocipastor", "Meilleur film du monde, gros budget", "https://avatar.iran.liara.run/public"),
      Article("Photo mouton béret paille ?", "Pourquoi", "https://avatar.iran.liara.run/public")
    );

    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)
        ) {
            Text(text = stringResource(R.string.title_list_article_page),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White, fontSize = 28.sp))
            LazyColumn {
                items(articles) { article ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp)
                    ) {
                        Row(modifier = Modifier.padding(10.dp)) {
                            AsyncImage(
                                model = article.imgPath,
                                contentDescription = "",
                                modifier = Modifier.width(82.dp).padding(horizontal = 5.dp),
                                placeholder = painterResource(R.drawable.reset_password_ic),
                                )
                            Column(modifier = Modifier.padding(start = 5.dp)) {
                                Text(article.title,
                                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp))
                                Text(article.desc)
                            }
                        }
                    }
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
    ListArticleActivityPage()
}