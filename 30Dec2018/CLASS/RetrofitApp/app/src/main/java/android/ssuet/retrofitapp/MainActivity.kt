package android.ssuet.retrofitapp

import android.app.Dialog
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),Callback<VolumesResponse>{

    var booksData:ArrayList<VolumesResponse.VolumeItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        booksList.adapter = BooksAdapter(booksData)
        booksList.layoutManager = LinearLayoutManager(this)

        apiBtn.setOnClickListener {
            Api().service.getVolumes("kotlin").enqueue(this)
//            Api().service.getVol("android").enqueue(this)


        }
    }

    override fun onFailure(call: Call<VolumesResponse>, t: Throwable) {

    }

    override fun onResponse(call: Call<VolumesResponse>, response: Response<VolumesResponse>) {
        val myVolumes = response.body()
        myVolumes?.also {vol ->
            vol.items?.also {
                Toast.makeText(this@MainActivity,"OK",Toast.LENGTH_SHORT).show()
                booksData.addAll(it.toList())
                booksList.adapter?.notifyDataSetChanged()
            }
        }
    }
}
