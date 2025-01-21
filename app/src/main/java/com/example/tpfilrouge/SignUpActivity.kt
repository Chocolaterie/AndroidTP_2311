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
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tpfilrouge.ui.theme.EniButton
import com.example.tpfilrouge.ui.theme.EniPage
import com.example.tpfilrouge.ui.theme.EniTextField
import com.example.tpfilrouge.ui.theme.TpFilRougeTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignUpActivityPage()
        }
    }
}

@Composable
fun SignUpActivityPage() {
    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)) {
            Image(
                painter = painterResource(id = R.drawable.sign_up),
                contentDescription = "Logo SignUp",
                modifier = Modifier.padding(vertical = 10.dp))
            EniTextField("Pseudo")
            EniTextField("Email")
            EniTextField("Password")
            EniTextField("Password Confirmation")
            EniTextField("City Code")
            EniTextField("City")
            EniTextField("Phone Number")
            EniButton("Sign Up", onClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpActivityPreview() {
    SignUpActivityPage()
}