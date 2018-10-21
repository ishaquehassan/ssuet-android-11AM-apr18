package wearkotlin.android.ssuet.commonintents

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val msg = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE)

        map_action.setOnClickListener {
            openMap()
        }

        url_action.setOnClickListener {
            openLink()
        }

        dial_action.setOnClickListener {
            dialAction()
        }
        alarm_action.setOnClickListener {
            setAlarm()
        }

        camera_action.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,2);
        }
        camera_full_action.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            i.putExtra(MediaStore.EXTRA_OUTPUT,Uri.withAppendedPath(
                    Uri.parse("file://myPhotosApp"),
                    "FullImage.jpg"
            ))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(
                        Manifest.permission.CAMERA
                ),2)
            }
            startActivityForResult(i,3);
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when(requestCode){
            2 ->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        if(data != null){
                            val myRawImage = data.extras.get("data")
                            mySelfie.setImageBitmap(myRawImage as Bitmap)
                        }
                    }
                    Activity.RESULT_CANCELED ->{
                        Toast.makeText(this,"Please capture :(",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            3->{
                if(data != null){
                    val myRawImage = data.extras.get("data")
                    mySelfieFull.setImageBitmap(myRawImage as Bitmap)
                }
            }
        }
    }

    fun openMap() {

        val uri = Uri.parse("https://www.google.com/maps/dir/24.8868825,67.0795538/Rehmania+Masjid,+Tariq+Rd,+%DA%A9%D8%B1%D8%A7%DA%86%DB%8C%D8%8C+Pakistan%E2%80%AD/@24.8723307,67.0621492,15z/data=!3m1!4b1!4m16!1m6!3m5!1s0x3eb33e8fbccecdb7:0x30ffe2ca7ca238d7!2sJamia+Masjid+Rehmania!8m2!3d24.8667243!4d67.0561782!4m8!1m1!4e1!1m5!1m1!1s0x3eb33e8fbccecdb7:0x30ffe2ca7ca238d7!2m2!1d67.0561782!2d24.8667243")
        val mapIntent = Intent(Intent.ACTION_VIEW, uri)

        startActivity(mapIntent)
    }

    fun openLink() {

        val uri = Uri.parse("https://www.google.com")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        startActivity(intent)
    }

    fun dialAction() {
        val uri = Uri.parse("tel:090078601")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        startActivity(intent)
    }

    fun setAlarm() {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM)
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm For Doc Appointment")
        intent.putExtra(AlarmClock.EXTRA_HOUR, 2)
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 30)
        startActivity(intent)

    }


}
