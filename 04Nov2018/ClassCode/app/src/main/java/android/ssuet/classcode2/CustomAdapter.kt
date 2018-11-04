package android.ssuet.classcode2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(con: Context, var data: ArrayList<String>) : ArrayAdapter<String>(con, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        }
        val user_text_view = view?.findViewById<TextView>(R.id.user_name)

        user_text_view?.text = data[position]

        return view
    }

}