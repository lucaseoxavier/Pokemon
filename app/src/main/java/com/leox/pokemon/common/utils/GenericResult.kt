package com.leox.pokemon.common.utils

import okhttp3.ResponseBody

sealed class GenericResult<out T> {
    data class Success<T>(val data: T) : GenericResult<T>()
    data class GenericError(val errorBody: ResponseBody?) : GenericResult<Nothing>()
}