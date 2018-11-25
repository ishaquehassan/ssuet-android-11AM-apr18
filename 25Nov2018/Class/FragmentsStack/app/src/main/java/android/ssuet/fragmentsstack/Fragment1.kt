package android.ssuet.fragmentsstack


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.RuntimeException

class Fragment1 : Fragment() {

    lateinit var name:String
    var listner:MyFragCallBack? = null

    override fun onAttach(context: Context?) {
        if(context is MyFragCallBack){
            listner = context
        }else{
            throw RuntimeException("")
        }
        Log.e("onAttach","Called")
        super.onAttach(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate","Called")
        name = arguments?.getString("name","Hello") ?: "Hello"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("onCreateView","Called")
        val v = inflater.inflate(R.layout.fragment_fragment1, container, false)
        v.findViewById<TextView>(R.id.myNameTvf1).text = name
        v.findViewById<Button>(R.id.etBtnf1).setOnClickListener {
            listner?.onFragItemClick(v.findViewById<EditText>(R.id.myEtf1).text.toString())
        }
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("onActivityCreated","Called")
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart","Called")

    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume","Called")
    }


}
