package com.example.countries.app.generalConfig

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class GeneralInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
        val response = chain.proceed(requestBuilder.build())

        if (response.code == 204) {
            throw RuntimeException()
        }

        return response
    }
}