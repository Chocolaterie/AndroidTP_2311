package com.example.tpfilrouge.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tpfilrouge.helpers.AlertDialogHelpers
import com.example.tpfilrouge.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ResetPasswordViewModel : ViewModel() {

    var email = MutableStateFlow("isaac@gmail.com")

    fun callResetPasswordApi(){
        AppDialogHelpers.get().showDialog("Envoie du mail de réinitialisation");

        viewModelScope.launch {
            // Appel api async
            val emailDTO = EmailDTO(email.value);
            val responseService = AuthService.AuthApi.authService.resetPassword(emailDTO);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            // Afficher le resultat de l'api
            AlertDialogHelpers.get().show(responseService.message, onClose = {})
        }
    }
}