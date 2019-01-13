package android.ssuet.roomadvance

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(entities = [Post::class],version = 2)
@TypeConverters(MyTypeConverter::class)
abstract class AppDb : RoomDatabase(){
    abstract fun postsDao():PostsDao
}