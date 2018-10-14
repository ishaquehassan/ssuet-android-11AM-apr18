package wearkotlin.android.ssuet.classcodeapp14oct

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animation_btn = findViewById<Button>(R.id.click_animation)

        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_left)
        animation.fillAfter = true
        animation_btn.setOnClickListener {
            animation_btn.startAnimation(animation)
        }

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                Toast.makeText(this@MainActivity, "animation End", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
    }
}
