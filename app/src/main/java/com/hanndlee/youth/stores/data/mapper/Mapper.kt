package com.hanndlee.youth.stores.data.mapper

import com.hanndlee.youth.stores.domain.model.ApiError
import com.hanndlee.youth.stores.domain.model.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toGeneralError(): NetworkError {
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return NetworkError(error, this)
}
