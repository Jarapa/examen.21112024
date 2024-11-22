package com.example.examenapiretrofitroom21112024.retrofit

import retrofit2.Response

inline fun <reified T> safeCall(
    execute: () -> Response<T>
): ApiResult<T, DataError.Network> {
    return try {
        val response = execute()

        when {
            response.isSuccessful -> {
                val body = response.body()
                if (body != null) {
                    ApiResult.Success(body)
                } else {
                    ApiResult.Error(DataError.Network.UNKNOWN)
                }
            }

            else -> {
                when (response.code()) {
                    400 -> ApiResult.Error(DataError.Network.BAD_REQUEST)
                    401 -> ApiResult.Error(DataError.Network.UNAUTHORIZED)
                    408 -> ApiResult.Error(DataError.Network.REQUEST_TIMEOUT)
                    409 -> ApiResult.Error(DataError.Network.CONFLICT)
                    413 -> ApiResult.Error(DataError.Network.PAYLOAD_TOO_LARGE)
                    429 -> ApiResult.Error(DataError.Network.TOO_MANY_REQUESTS)
                    in 500..599 -> ApiResult.Error(DataError.Network.SERVER_ERROR)
                    else -> ApiResult.Error(DataError.Network.UNKNOWN)
                }
            }
        }
    } catch (e: Exception) {
        ApiResult.Error(DataError.Network.UNKNOWN)
    }
}