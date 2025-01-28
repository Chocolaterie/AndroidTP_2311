package com.example.tpfilrouge.helpers

data class AlertDialogModelData(var isShow : Boolean = false, var message : String = "", var onClose : () -> Unit = {}) {
}