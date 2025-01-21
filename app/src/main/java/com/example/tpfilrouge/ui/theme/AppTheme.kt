package com.example.tpfilrouge.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.example.tpfilrouge.R

class AppTheme {
}

@Composable
fun HintText(label : String){
    Text(text = label, style = TextStyle(color = Color.Gray))
}

@Composable
fun EniTextField(label : String){
    TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),
        placeholder = { HintText(label) })
}

@Composable
fun EniBackgroundPage(){
    Image(
        painter = painterResource(id = R.drawable.background_mobile),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}