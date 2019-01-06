package android.ssuet.roomdb

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insert(contact:ContactItem)

    @Delete
    fun delete(contact:ContactItem)

    @Query("SELECT * FROM ContactItem")
    fun getAll():List<ContactItem>

}