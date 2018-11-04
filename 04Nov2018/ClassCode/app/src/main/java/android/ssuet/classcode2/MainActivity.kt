package android.ssuet.classcode2

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val users = arrayListOf("arbaz", "ishaq", "usman", "talha", "usama")

        val spinAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, users)

        spinner.adapter = spinAdapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                T("Nothing")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                T(users[position])
            }

        }


        add_user.setOnClickListener {

            val user = user_data.text.toString()
            users.add(user)
            user_data.setText("")

            T("user added")


        }


    }


}

fun Context.T(mess: String) {
    Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
}
