package com.ydhnwb.learndagger.di

import androidx.lifecycle.ViewModel
import com.ydhnwb.learndagger.ui.fragments.note.NoteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindNoteViewModel(noteViewModel :NoteViewModel) : ViewModel
}