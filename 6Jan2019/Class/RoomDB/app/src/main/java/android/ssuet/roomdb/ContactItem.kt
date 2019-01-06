package android.ssuet.roomdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class ContactItem(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val name:String,
    @ColumnInfo val phone:String
)