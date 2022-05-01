package com.mvrx.data.remote

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import com.google.gson.Gson
import com.mvrx.data.api.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    /**
     * Get [Retrofit] instance.
     * @return instances of [Retrofit]
     */
    @RequiresPermission(value = Manifest.permission.INTERNET)
    fun getRetrofit(
        context: Context,
        okHttpClientFactory: OkHttpClientFactory
    ): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClientFactory.createOkHttpClient(context))
            .build()

}