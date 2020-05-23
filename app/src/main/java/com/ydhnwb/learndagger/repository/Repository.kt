package com.ydhnwb.learndagger.repository

import androidx.lifecycle.LiveData
import com.ydhnwb.learndagger.database.note.Note
import com.ydhnwb.learndagger.database.note.NoteDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(val noteDao: NoteDao) {
    fun insert(note: Note){
        CoroutineScope(Dispatchers.IO).launch{
            noteDao.insert(note)
        }
    }

    fun update(note: Note){
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.update(note)
        }
    }

    fun delete(note: Note){
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.delete(note)
        }
    }


    fun all() : LiveData<List<Note>>{
        return noteDao.all()
    }
}