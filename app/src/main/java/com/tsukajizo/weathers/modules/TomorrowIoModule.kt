package com.tsukajizo.weathers.modules

import com.squareup.moshi.Moshi
import com.tsukajizo.weathers.service.tomorrowio.TomorrowIoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * com.tsukajizo.weathers.modules
 */
@Module
@InstallIn(SingletonComponent::class)
class TomorrowIoModule {

    companion object{
        const val TOMORROW_IO_BASE_URL = "https://api.tomorrow.io"
    }

    @Singleton
    @Provides
    fun provideTomorrowIoRetrofit(moshi: Moshi): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logger)
        return Retrofit.Builder()
            .baseUrl(TOMORROW_IO_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideTomorrowIoService(retrofit: Retrofit): TomorrowIoService = retrofit.create(TomorrowIoService::class.java)

}