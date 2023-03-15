package ru.edgestreams.demo

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.edgestreams.demo.model.data.remote.auth.AuthApi
import ru.edgestreams.demo.model.data.remote.refresh_token.RefreshTokenApi
import ru.edgestreams.demo.model.data.remote.streams.StreamsApi

class EdgeApp : Application() {

    lateinit var authApi: AuthApi
    lateinit var refreshTokenApi: RefreshTokenApi
    lateinit var streamsApi: StreamsApi

    override fun onCreate() {
        super.onCreate()
        configureNetwork()
    }

    private fun configureNetwork() {
        //For logging requests
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())     //To convert Json to Kotlin objects
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())      //To convert retrofit responses to rxjava objects
            .build()

        authApi = retrofit.create(AuthApi::class.java)
        refreshTokenApi = retrofit.create(RefreshTokenApi::class.java)
        streamsApi = retrofit.create(StreamsApi::class.java)
    }

    companion object {
        private const val BASE_URL = "https://api.edgecenter.ru"
    }
}