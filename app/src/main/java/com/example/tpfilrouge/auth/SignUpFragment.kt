package com.example.tpfilrouge.auth

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

@Composable
fun SignUpFragmentPage(signUpViewModel: SignUpViewModel) {
    // Ecouter et synchronser les champs saisies
    val emailField by signUpViewModel.email.collectAsState()
    val pseudoField by signUpViewModel.pseudo.collectAsState()
    val passwordField by signUpViewModel.password.collectAsState()
    val passwordConfirmField by signUpViewModel.passwordConfirm.collectAsState()
    val cityCodeField by signUpViewModel.cityCode.collectAsState()
    val cityField by signUpViewModel.city.collectAsState()
    val phoneField by signUpViewModel.phone.collectAsState()

    EniPage {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sign_up),
                contentDescription = "Logo SignUp",
                modifier = Modifier.padding(vertical = 10.dp)
            )
            EniTextField(
                "Pseudo",
                value = pseudoField,
                onValueChange = { value -> signUpViewModel.pseudo.value = value; })
            EniTextField(
                "Email",
                value = emailField,
                onValueChange = { value -> signUpViewModel.email.value = value; })
            EniTextField(
                "Password",
                value = passwordField,
                onValueChange = { value -> signUpViewModel.password.value = value; })
            EniTextField(
                "Password Confirmation",
                value = passwordConfirmField,
                onValueChange = { value -> signUpViewModel.passwordConfirm.value = value; })
            EniTextField(
                "City Code",
                value = cityCodeField,
                onValueChange = { value -> signUpViewModel.cityCode.value = value; })
            EniTextField(
                "City",
                value = cityField,
                onValueChange = { value -> signUpViewModel.city.value = value; })
            EniTextField(
                "Phone Number",
                value = phoneField,
                onValueChange = { value -> signUpViewModel.phone.value = value; })
            EniButton("Sign Up", onClick = { signUpViewModel.callSignUpApi() })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpFragmentPreview() {
    SignUpFragmentPage(SignUpViewModel())
}