package com.ydhnwb.learndagger

import com.ydhnwb.learndagger.di.AppComponent
import com.ydhnwb.learndagger.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()





}