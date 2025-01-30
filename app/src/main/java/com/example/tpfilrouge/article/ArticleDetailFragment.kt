package com.example.tpfilrouge.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniPage


@Composable
fun DetailArticleFragmentPage(
    viewModel: DetailArticleViewModel
) {
    // Ecouter les changements de la liste d'article dans le ViewModel
    val articleState by viewModel.article.collectAsState();

    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)
        ) {
            Text(
                text = articleState.title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White, fontSize = 28.sp)
            )
            Row(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .padding(vertical = 14.dp)) {
                AsyncImage(
                    model = articleState.imgPath,
                    contentDescription = "",
                    modifier = Modifier
                        .width(82.dp)
                        .padding(horizontal = 5.dp),
                    placeholder = painterResource(R.drawable.reset_password_ic),
                )
                Column(modifier = Modifier.padding(start = 5.dp)) {
                    Text(articleState.desc, style = TextStyle(color = Color.White, fontSize = 20.sp))
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun DetailArticleFragmentPreview() {
    var viewModel = DetailArticleViewModel();
    DetailArticleFragmentPage(viewModel)
}