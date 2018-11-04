package android.ssuet.classcode2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val users = arrayListOf("arbaz", "ishaq", "usman", "talha", "usama","arbaz", "ishaq", "usman", "talha", "usama","arbaz", "ishaq", "usman", "talha", "usama")

//        val listAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,users)
//        val listAdapter = CustomAdapter(this,users)


        val userList = ArrayList<UserModal>()

        userList.add(UserModal("ishaq",24,R.drawable.icon_one))
        userList.add(UserModal("arbaz",24,R.drawable.icon_two))
        userList.add(UserModal("usman",34,R.drawable.icon_three))
        userList.add(UserModal("rameez",54,R.drawable.icon_four))
        userList.add(UserModal("ishaq",64,R.drawable.icon_five))


        val listAdapter = UserCustomAdapter(this,userList)

        list.adapter = listAdapter


        list.setOnItemClickListener { parent, view, position, id ->
            T(users[position])
        }

    }
}
