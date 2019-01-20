package session.ssuet.firebasedatabase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseDatabase.getInstance()
        val dbRef = db.getReference("sample")

        insertData.setOnClickListener {
            dbRef.setValue(etVal.text.toString())
        }

        delData.setOnClickListener {
            dbRef.removeValue()
        }

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataSnap: DataSnapshot) {
                val myVal = dataSnap.getValue(String::class.java)
                myFireData.text = myVal
            }

        })
    }
}
