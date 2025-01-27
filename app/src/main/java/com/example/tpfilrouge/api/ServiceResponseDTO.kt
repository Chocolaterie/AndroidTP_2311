package com.example.tpfilrouge.api

data class ServiceResponseDTO<T>(var code: String, var message : String, var data : T?) {
}