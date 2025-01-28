package com.example.tpfilrouge.auth

import androidx.compose.material3.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tpfilrouge.helpers.AlertDialogHelpers
import com.example.tpfilrouge.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    // Ecouter la saisie de email et password
    var email = MutableStateFlow("isaac@gmail.com")
    var password = MutableStateFlow("password")

    fun callLoginApi(onSuccess : () -> Unit = {}){
        AppDialogHelpers.get().showDialog("Tentive de connexion...");

        viewModelScope.launch {
            // Preparer le DTO à envoyer dans request body
            // Le DTO qui contient : email et password
            val loginRequest = LoginRequestDTO(email.value, password.value);

            // Appel api async
            val responseService = AuthService.AuthApi.authService.login(loginRequest);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            // Si connexion ok
            if (responseService.code.equals("200")){
                //AlertDialogHelpers.get().show(responseService.message, onClose = { onSuccess() })
                AlertDialogHelpers.get().show(responseService.message, onClose = onSuccess)
            }
            else{
                // Erreur
                AlertDialogHelpers.get().show(responseService.message, onClose = {})
            }
        }
    }
}