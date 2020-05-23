package com.ydhnwb.learndagger.di

import com.ydhnwb.learndagger.ui.activities.MainActivity
import com.ydhnwb.learndagger.ui.fragments.note.AllNoteFragment
import com.ydhnwb.learndagger.ui.fragments.note.CreateNoteFragment
import com.ydhnwb.learndagger.ui.fragments.note.EditNoteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [
        ViewModelModule::class,
        FragmentBuilderModule::class
    ])
    abstract fun contributeMainActivity() : MainActivity
}