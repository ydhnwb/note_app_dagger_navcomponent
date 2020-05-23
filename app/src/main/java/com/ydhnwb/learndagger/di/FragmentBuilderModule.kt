package com.ydhnwb.learndagger.di

import com.ydhnwb.learndagger.ui.fragments.note.AllNoteFragment
import com.ydhnwb.learndagger.ui.fragments.note.CreateNoteFragment
import com.ydhnwb.learndagger.ui.fragments.note.EditNoteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule{
    @ContributesAndroidInjector
    abstract fun contributeCreateNoteFragment() : CreateNoteFragment

    @ContributesAndroidInjector
    abstract fun contributeEditNoteFragment() : EditNoteFragment

    @ContributesAndroidInjector
    abstract fun contributeAllNoteFragment() : AllNoteFragment
}