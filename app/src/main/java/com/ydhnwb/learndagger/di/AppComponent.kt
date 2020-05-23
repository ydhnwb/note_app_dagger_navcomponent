package com.ydhnwb.learndagger.di

import android.app.Application
import com.ydhnwb.learndagger.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    ViewModelFactoryModule::class
])
interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    interface Builder {
        fun build() : AppComponent

        @BindsInstance
        fun application(app: Application) : Builder
    }
}