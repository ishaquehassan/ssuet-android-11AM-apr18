package com.ishaquehassan.finalclass.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ishaquehassan.finalclass.BuildConfig
import com.ishaquehassan.finalclass.R
import com.ishaquehassan.finalclass.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)



        when(BuildConfig.FLAVOR){
            "local"->textViewData.text = "bilal"
            "dev"->textViewData.text = "sir ishaq"
            "prod"->textViewData.text = "Kisi kou hi nahi"
        }


        val observer = Observer<String>{
            textViewData.text = mainActivityViewModel.data.value
        }

        mainActivityViewModel.data.observe(this,observer)


        buttonData.setOnClickListener {
            mainActivityViewModel.data.value = editTextData.text.toString()

        }
    }
}
