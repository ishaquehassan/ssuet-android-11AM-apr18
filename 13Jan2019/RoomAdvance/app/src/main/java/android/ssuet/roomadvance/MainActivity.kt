package android.ssuet.roomadvance

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var db: AppDb
    lateinit var posts:ArrayList<Post>
    var updateId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        posts = arrayListOf()

        db = Room.databaseBuilder(
            this,
            AppDb::class.java,
            "socialDB").allowMainThreadQueries().fallbackToDestructiveMigration().build()

        myList.adapter = RecyclerGeneralViewTypeAdapter(posts,R.layout.item_view){view,post,position ->
            view.findViewById<TextView>(R.id.idTv).text = post.id.toString()
            view.findViewById<TextView>(R.id.textTv).text = post.text
            view.setOnClickListener {
                textEt.setText(post.text)
                updateId = post.id
            }
        }
        myList.layoutManager = LinearLayoutManager(this)
        updateList()

        saveBtn.setOnClickListener {
            val text = textEt.text.toString()
            if(text.isEmpty()){
                textEt.error = "Please Enter Some Text!"
                return@setOnClickListener
            }
            textEt.error = null
            textEt.setText("")
            save(text)

        }
    }

    private fun updateList(){
        posts.clear()
        posts.addAll(db.postsDao().getAll())
        myList.adapter?.notifyDataSetChanged()
    }

    private fun save(text:String){
        if(updateId == 0){
            db.postsDao().insert(Post(text = text, comments = arrayOf("Comment 1","Comment 2"),user = PostUser("Student")))
        }else{
            db.postsDao().update(Post(updateId,text, arrayOf("Comment 1","Comment 2"),PostUser("Student")))
        }
        updateId = 0
        updateList()
    }
}
