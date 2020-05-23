package com.ydhnwb.learndagger.database.note

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note : Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("select * from notes")
    fun all() : LiveData<List<Note>>

    @Query("select * from notes where id=:id LIMIT 1")
    fun find(id : Int) : Note
}