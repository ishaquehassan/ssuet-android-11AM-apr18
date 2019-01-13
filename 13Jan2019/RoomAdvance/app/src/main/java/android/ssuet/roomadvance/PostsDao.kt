package android.ssuet.roomadvance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface PostsDao {

    @Query("SELECT * FROM Post WHERE id = :id")
    fun getById(id:Int):Post

    @Query("SELECT * FROM Post ORDER BY id DESC")
    fun getAll():List<Post>

    @Insert
    fun insert(post: Post)

    @Update
    fun update(post: Post)

}