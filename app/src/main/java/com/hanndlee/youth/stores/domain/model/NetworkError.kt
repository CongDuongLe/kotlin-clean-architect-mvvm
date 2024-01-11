package com.hanndlee.youth.stores.domain.model

data class NetworkError(
    val error: ApiError,
    val t : Throwable? = null
)


enum class ApiError(val mes:String){
    NetworkError("Unknown network error"),
    ServerError("Unknown server error"),
    UnknownError("Unknown error"),
    UnknownResponse("Unknown response")
}