package android.ssuet.classcode2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class UserCustomAdapter(con: Context, var data: ArrayList<UserModal>) : ArrayAdapter<UserModal>(con, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_user_view, parent, false)
        }
        val user_text_view = view?.findViewById<TextView>(R.id.user_name)

        val age_text_view = view?.findViewById<TextView>(R.id.user_age)

        val user_img = view?.findViewById<ImageView>(R.id.user_img)

        val userData = data[position]

        user_text_view?.text = userData.name

        age_text_view?.text = userData.age.toString()

        user_img?.setImageResource(userData.img)


        return view
    }

}