package android.ssuet.retrofitapp

import java.io.Serializable

class VolumesResponse : Serializable{
    val totalItems:Int = 0

    val items:Array<VolumeItem>? = null

    class VolumeItem{
        val volumeInfo:VolumeInfo? = null

        class VolumeInfo{
            val title:String? = null
            val authors:Array<String> = arrayOf()
            val imageLinks:VolumeImages? = null

            class VolumeImages{
                val smallThumbnail:String? = null
                val thumbnail:String? = null
            }
        }
    }

}