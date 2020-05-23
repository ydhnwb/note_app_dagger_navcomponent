package com.ydhnwb.learndagger.ui.fragments.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydhnwb.learndagger.database.note.Note
import com.ydhnwb.learndagger.repository.Repository
import javax.inject.Inject

class NoteViewModel @Inject constructor(val noteRepository: Repository) : ViewModel(){

    fun insert(note: Note) { noteRepository.insert(note) }
    fun delete(note: Note) { noteRepository.delete(note) }
    fun update(note: Note) { noteRepository.update(note) }
    fun fetchAll() = noteRepository.all()

}