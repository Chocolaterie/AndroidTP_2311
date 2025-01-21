package com.example.tpfilrouge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tpfilrouge.ui.theme.TpFilRougeTheme
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniBackgroundPage
import com.example.tpfilrouge.ui.theme.EniTextField

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginActivityPage()
        }
    }
}

@Composable
fun LoginActivityPage() {
    TpFilRougeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                EniBackgroundPage()
                Column(modifier = Modifier.padding(40.dp)) {
                    Text(
                        text = "Login", textAlign = TextAlign.Center,
                        fontSize = 46.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 80.dp)
                    )
                    EniTextField("Email")
                    EniTextField("Password")
                    ElevatedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Connexion")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginActivityPreview() {
    LoginActivityPage()
}