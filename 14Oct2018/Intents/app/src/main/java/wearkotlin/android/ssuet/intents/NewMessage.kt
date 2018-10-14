package wearkotlin.android.ssuet.intents

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NewMessage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

        findViewById<Button>(R.id.btnDone)
                .setOnClickListener {
                    val name = findViewById<EditText>(R.id.etName).text.toString()
                    val intent = Intent()
                    intent.putExtra("name",name)
                    setResult(RESULT_OK,intent)
                    finish()
                }

    }
}
