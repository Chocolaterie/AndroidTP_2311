package com.example.tpfilrouge.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniButton
import com.example.tpfilrouge.ui.theme.EniPage
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

    val context = LocalContext.current;

    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_user),
                contentDescription = "Logo Login",
                modifier = Modifier.padding(vertical = 40.dp)
            )
            Text(
                text = stringResource(R.string.aware_login),
                modifier = Modifier.padding(vertical = 40.dp),
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color(0xCCFFFFFF))
            )
            EniTextField(stringResource(R.string.email))
            EniTextField(stringResource(R.string.password))
            EniButton(stringResource(R.string.connection), onClick = {})
            EniButton(stringResource(R.string.forget_password),
                onClick = {
                    // Changer de page (d'activity)
                    context.startActivity(Intent(context, ResetPasswordActivity::class.java))
                })
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.dont_account),
                modifier = Modifier.padding(vertical = 10.dp),
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color(0xCCFFFFFF))
            )
            EniButton(stringResource(R.string.register_now),
                onClick = {
                    // Changer de page (d'activity)
                    context.startActivity(Intent(context, SignUpActivity::class.java))
                })
        }
    }

}

@Preview(
    showBackground = true,
    locale = "en"
)
@Composable
fun LoginActivityPreview() {
    LoginActivityPage()
}