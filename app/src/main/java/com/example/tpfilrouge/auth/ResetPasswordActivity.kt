package com.example.tpfilrouge.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tpfilrouge.R
import com.example.tpfilrouge.ui.theme.EniButton
import com.example.tpfilrouge.ui.theme.EniPage
import com.example.tpfilrouge.ui.theme.EniTextField

class ResetPasswordActivity : ComponentActivity() {

    var resetPasswordViewModel = ResetPasswordViewModel();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResetPasswordActivityPage(resetPasswordViewModel)
        }
    }
}

@Composable
fun ResetPasswordActivityPage(resetPasswordViewModel: ResetPasswordViewModel) {
    val emailField by resetPasswordViewModel.email.collectAsState();

    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)) {
            Image(
                painter = painterResource(id = R.drawable.reset_password_ic),
                contentDescription = "Logo SignUp",
                modifier = Modifier.padding(vertical = 40.dp))
            EniTextField("Email", value = emailField, onValueChange = { value -> resetPasswordViewModel.email.value = value})
            EniButton("Envoyer le lien de récupération", onClick = { resetPasswordViewModel.callResetPasswordApi() })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordActivityPreview() {
    ResetPasswordActivityPage(ResetPasswordViewModel())
}