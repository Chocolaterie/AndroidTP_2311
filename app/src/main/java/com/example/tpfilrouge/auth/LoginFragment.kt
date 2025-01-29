package com.example.tpfilrouge.auth

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavController
import com.example.tpfilrouge.R
import com.example.tpfilrouge.article.ListArticleActivity
import com.example.tpfilrouge.ui.theme.EniButton
import com.example.tpfilrouge.ui.theme.EniPage
import com.example.tpfilrouge.ui.theme.EniTextField

@Composable
fun LoginFragmentPage(loginViewModel: LoginViewModel, navController: NavController? = null) {
    // Ecouter les changements de l'email et mot de passe saisies
    val emailField by loginViewModel.email.collectAsState()
    val passwordField by loginViewModel.password.collectAsState()

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
            EniTextField(
                stringResource(R.string.email),
                value = emailField,
                onValueChange = { value -> loginViewModel.email.value = value; })
            EniTextField(
                stringResource(R.string.password),
                value = passwordField,
                onValueChange = { value -> loginViewModel.password.value = value; })
            EniButton(stringResource(R.string.connection), onClick = {
                loginViewModel.callLoginApi(
                    onSuccess = {
                        // je change de page (page article
                        context.startActivity(Intent(context, ListArticleActivity::class.java))
                    }
                )
            })
            EniButton(stringResource(R.string.forget_password),
                onClick = {
                    navController!!.navigate("reset_password");
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
                    navController!!.navigate("sign_up");
                })
        }
    }

}

@Preview(
    showBackground = true,
    locale = "en"
)
@Composable
fun LoginFragmentPreview() {
    LoginFragmentPage(LoginViewModel())
}