package android.ssuet.retrofitapp

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class Api {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com")
        .addConverterFactory(GsonConverterFactory.create())
        //.addConverterFactory(ScalarsConverterFactory.create())
        .client(OkHttpClient().newBuilder().addInterceptor(StethoInterceptor()).build())
        .build()

    val service = retrofit.create(BooksApi::class.java)
}