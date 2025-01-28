package com.example.tpfilrouge.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tpfilrouge.helpers.AlertDialogHelpers
import com.example.tpfilrouge.helpers.AppDialogHelpers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    var email = MutableStateFlow("velocipastor@gmail.com")
    var pseudo = MutableStateFlow("Lepuitdefou")
    var password = MutableStateFlow("13456")
    var passwordConfirm = MutableStateFlow("13456")
    var cityCode = MutableStateFlow("44300")
    var city = MutableStateFlow("Nantes")
    var phone = MutableStateFlow("0612326699")

    fun callSignUpApi(){
        AppDialogHelpers.get().showDialog("Inscription en cours");

        viewModelScope.launch {
            // Preparer le DTO à envoyer dans request body
            // Le DTO qui contient : email et password
            val signUpRequestDTO = SignUpRequestDTO(email.value, pseudo.value, password.value,
                passwordConfirm.value, cityCode.value, city.value, phone.value);

            // Appel api async
            val responseService = AuthService.AuthApi.authService.signup(signUpRequestDTO);

            // Fermer la popup de chargement aprés l'appel de API
            AppDialogHelpers.get().closeDialog()

            // Si connexion ok
            if (responseService.code.equals("200")){
                //AlertDialogHelpers.get().show(responseService.message, onClose = { onSuccess() })
                AlertDialogHelpers.get().show(responseService.message, onClose = {})
            }
            else{
                // Erreur
                AlertDialogHelpers.get().show(responseService.message, onClose = {})
            }
        }
    }
}
