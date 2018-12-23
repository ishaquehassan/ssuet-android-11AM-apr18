package android.ssuet.httpgsondemo

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
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
            Httptaask().execute("https://api.github.com/users/ishaquehassan/repos")
        }
    }

    inner class Httptaask : AsyncTask<String, Unit, String>(){
        override fun doInBackground(vararg params: String):String{
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpURLConnection
            return try {
                val inpStream = BufferedInputStream(urlConnection.getInputStream())
                val reader = InputStreamReader(inpStream)
                val responseLines = reader.readLines()
                responseLines.joinToString("\n")
            } catch (e: Exception){
                return "No Response"
            } finally {
                urlConnection.disconnect()
            }
        }

        override fun onPostExecute(result: String) {
            val repos = Gson().fromJson(result,Array<Repo>::class.javaObjectType)
            myResponseTV.text = repos.map { it.full_name }.joinToString(",")
        }

    }
}
