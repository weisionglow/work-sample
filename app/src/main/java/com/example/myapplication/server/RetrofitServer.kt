package com.example.myapplication.server

import android.content.Context
import android.util.Log
import androidx.databinding.ktx.BuildConfig
import com.example.myapplication.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitServer {

    private var apiClient: ApiClient? = null
    private const val TIMEOUT_SECOND = 30L

    fun getInstance(context: Context? = null): ApiClient? {
        if (context != null && apiClient == null) {
            val clientBuilder = OkHttpClient.Builder()
            clientBuilder.connectTimeout(TIMEOUT_SECOND, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SECOND, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SECOND, TimeUnit.SECONDS)

            if (BuildConfig.DEBUG) {
                val logger = HttpLoggingInterceptor.Logger {
                    Log.d("###", it)
                }

                val interceptor = HttpLoggingInterceptor(logger)
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                clientBuilder.addInterceptor(interceptor)
            }

            val retrofit = Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiInterface = retrofit.create(ApiInterface::class.java)
            apiClient = ApiClient(apiInterface)

        }
        return apiClient
    }

    fun refreshRetrofitServer(context: Context?) {
        apiClient = null
        getInstance(context)
    }

    class AddHeaderInterceptor(context: Context, accessToken: String?) : Interceptor {
        var context = context
        var accesstokenStored = accessToken

        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val builder = chain.request().newBuilder()
            if (!accesstokenStored.isNullOrEmpty()) {
                builder.addHeader("Authorization", "Bearer ${accesstokenStored!!}")
            }

            return chain.proceed(builder.build())
        }

    }
}