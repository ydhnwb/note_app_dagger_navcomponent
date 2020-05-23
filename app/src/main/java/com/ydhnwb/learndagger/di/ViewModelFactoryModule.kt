package com.ydhnwb.learndagger.di

import androidx.lifecycle.ViewModelProvider
import com.ydhnwb.learndagger.utils.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory

}