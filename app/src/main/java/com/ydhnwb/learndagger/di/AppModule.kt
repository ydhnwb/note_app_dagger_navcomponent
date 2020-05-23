package com.ydhnwb.learndagger.di

import android.app.Application
import androidx.room.Room
import com.ydhnwb.learndagger.database.AppDatabase
import com.ydhnwb.learndagger.database.note.NoteDao
import com.ydhnwb.learndagger.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesNoteDao(appDatabase: AppDatabase) = appDatabase.noteDao()


    @Singleton
    @Provides
    fun providesAppDatabase(application: Application) : AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "learn_dagger").build()

    @Singleton
    @Provides
    fun providesRepository(noteDao: NoteDao) : Repository = Repository(noteDao)
}