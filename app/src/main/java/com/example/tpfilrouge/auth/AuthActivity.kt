package com.example.tpfilrouge.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class AuthActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthActivityPage()
        }
    }
}

@Composable
fun AuthActivityPage() {
    val navController = rememberNavController();

    NavHost(
        navController = navController,
        startDestination = "login"
    ){
        composable("login") {  LoginFragmentPage(LoginViewModel(), navController) }
        composable("sign_up") {  SignUpFragmentPage(SignUpViewModel()) }
        composable("reset_password") {  ResetPasswordFragmentPage(ResetPasswordViewModel()) }
    }
}

@Preview(
    showBackground = true,
    locale = "en"
)
@Composable
fun AuthActivityPreview() {
    AuthActivityPage()
}