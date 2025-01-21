package com.example.tpfilrouge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tpfilrouge.ui.theme.TpFilRougeTheme
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniBackgroundPage
import com.example.tpfilrouge.ui.theme.EniButton
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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(40.dp)) {
                    Image(
                        painter = painterResource(id=R.drawable.login_user),
                        contentDescription = "Logo Login",
                        modifier = Modifier.padding(vertical = 40.dp))
                    Text(text = stringResource(R.string.aware_login),
                        modifier = Modifier.padding(vertical = 40.dp),
                        textAlign = TextAlign.Center,
                        style = TextStyle(color = Color(0xCCFFFFFF))
                    )
                    EniTextField(stringResource(R.string.email))
                    EniTextField(stringResource(R.string.password))
                    EniButton(stringResource(R.string.connection))
                    EniButton(stringResource(R.string.forget_password))
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = stringResource(R.string.dont_account),
                        modifier = Modifier.padding(vertical = 10.dp),
                        textAlign = TextAlign.Center,
                        style = TextStyle(color = Color(0xCCFFFFFF))
                    )
                    EniButton(stringResource(R.string.register_now))
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    locale = "zh"
)
@Composable
fun LoginActivityPreview() {
    LoginActivityPage()
}