package com.example.tpfilrouge.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.tpfilrouge.R

class AppTheme {
}

@Composable
fun HintText(label : String){
    Text(text = label, style = TextStyle(color = Color.Gray))
}

@Composable
fun EniButton(label: String){
    Button(onClick = {},
        border = BorderStroke(3.dp, Color(0x77FFFFFF)),
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(contentAlignment = Alignment.Center,
            modifier =
            Modifier.background(brush = Brush.linearGradient(listOf(
                Color(0xFF8BC2FF),
                Color(0xFFA670B8),
            )))
                .fillMaxWidth()
                .padding(vertical = 15.dp)
        ) {
            Text(label)
        }
    }
}

@Composable
fun EniTextField(label : String){
    TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),
        placeholder = { HintText(label) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x44000000),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(40.dp)
    )
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