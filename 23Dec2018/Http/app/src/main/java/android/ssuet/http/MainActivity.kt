package android.ssuet.http

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.ssuet.http.R.id.myResponseTV
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    data class Repo(val id:Long,val full_name:String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        myTestBtn.setOnClickListener {
            //MyBackgroundTask().execute("Hello")
            Httptaask().execute("https://api.github.com/users/ishaquehassan/repos")
        }
    }

    inner class Httptaask : AsyncTask<String,Unit,String>(){
        override fun doInBackground(vararg params: String):String{
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpURLConnection
            return try {
                val inpStream = BufferedInputStream(urlConnection.getInputStream())
                val reader = InputStreamReader(inpStream)
                val responseLines = reader.readLines()
                responseLines.joinToString("\n")
            } catch (e:Exception){
                return "No Response"
            } finally {
                urlConnection.disconnect()
            }
        }

        override fun onPostExecute(result: String) {
            val dataArray = JSONArray(result)
            val myData = arrayListOf<Repo>()
            for(repoIndex in 0 until dataArray.length()){
                val myItem = dataArray.getJSONObject(repoIndex)
                myData.add(Repo(myItem.getLong("id"),myItem.getString("full_name")))
            }
            /*val firstObject = dataArray.getJSONObject(0)
            val fullName = firstObject.getString("full_name_h")*/
            myResponseTV.text = myData.map { it.full_name }.joinToString(",")
        }

    }


    inner class MyBackgroundTask : AsyncTask<String,Int,String?>(){
        override fun doInBackground(vararg params: String?): String? {
            for(i in 1..10){
                for(j in 1..1000000000){
                }
                publishProgress(i)
            }
            return params[0]
        }

        override fun onProgressUpdate(vararg values: Int?) {
            myResponseTV.text = "Iteration : ${values[0]}"
        }

        override fun onPostExecute(result: String?) {
            Toast.makeText(this@MainActivity,result,Toast.LENGTH_SHORT).show()
        }

    }
}
