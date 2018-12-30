package android.ssuet.retrofitapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi{

    @GET("books/v1/volumes")
    fun getVolumes(@Query("q") q:String):Call<VolumesResponse>
}