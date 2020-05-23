package com.ydhnwb.learndagger.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ydhnwb.learndagger.database.note.Note
import com.ydhnwb.learndagger.database.note.NoteDao

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun noteDao() : NoteDao
}
