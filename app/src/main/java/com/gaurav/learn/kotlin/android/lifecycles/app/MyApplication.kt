package com.gaurav.learn.kotlin.android.lifecycles.app

import android.app.Application
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        Timber.i("~~~ MyApplication onCreate() ~~~")

        ProcessLifecycleOwner.get().lifecycle.addObserver(MyAppLifecycleObserver())

    }


}

class MyAppLifecycleObserver : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Timber.i("~~~ application is in foreground ~~~")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Timber.i("~~~ application is in background ~~~")
    }
}