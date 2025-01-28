package com.example.tpfilrouge.helpers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.flow.MutableStateFlow

class AlertDialogHelpers {

    companion object {
        val instance : AlertDialogHelpers by lazy { AlertDialogHelpers() }

        fun get() : AlertDialogHelpers {
            return instance;
        }
    }

    // Sert à savoir en temps réel si il faut afficher ou pas la dialog
    var alertDialogModelData = MutableStateFlow(AlertDialogModelData());

    /**
     * Afficher la popup
     */
    fun show(message: String, onClose : () -> Unit){
        // Forcer le rafraichissement de l'etat
        alertDialogModelData.value = alertDialogModelData.value.copy(
            isShow = true,
            message = message,
            onClose = onClose);
    }

    /**
     * Fermer la popup
     */
    fun closeDialog() {
        // Forcer le rafraichissement de l'etat
        alertDialogModelData.value = alertDialogModelData.value.copy(isShow = false);
    }
}

@Composable
fun AlertDialog(){
    // Je vais ecouter quand la dialog est true ou false
    // Donc quand je dois afficher ou pas
    val alertDialogModelDataState by AlertDialogHelpers.get().alertDialogModelData.collectAsState();

    if (alertDialogModelDataState.isShow) {
        Dialog(onDismissRequest = {
            // Fermer la popup
            AlertDialogHelpers.get().closeDialog();
            // Appeler le callback
            alertDialogModelDataState.onClose();
        }){
            Box(modifier = Modifier.background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(30.dp)
            )
                .padding(20.dp)) {
                Text(text = alertDialogModelDataState.message)
            }
        }
    }
}