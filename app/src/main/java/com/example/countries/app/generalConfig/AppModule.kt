package com.example.countries.app.generalConfig

import android.app.Application
import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.example.countries.R
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    @Named(BASE_URL)
    fun provideBaseUrl(context: Context): String {
        return context.getString(R.string.base_url)
    }

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(
    ): OkHttpClient.Builder {

        return OkHttpClient()
            .newBuilder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(GeneralInterceptor())
    }

    @Singleton
    @Provides
    @Named(PROVIDE_APOLLO_CLIENT)
    fun provideRemoteDataProviderGet(
        okHttpClientBuilder: OkHttpClient.Builder,
        @Named(BASE_URL) baseUrl: String
    ): ApolloClient {
        val okbuilder = okHttpClientBuilder
            .connectTimeout(CONNECT_TIMEOUT_GET, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_GET, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT_GET, TimeUnit.SECONDS)
            .build()

        return ApolloClient.Builder().serverUrl(baseUrl).okHttpClient(okbuilder).build()
    }

}