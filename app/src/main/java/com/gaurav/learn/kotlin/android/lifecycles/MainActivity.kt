package com.gaurav.learn.kotlin.android.lifecycles

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.i("~~~ onCreate() ~~~")

    }

    fun startNextActivity(view: View) {
        SecondActivity.start(this@MainActivity)
    }

    override fun onDestroy() {
        Timber.i("~~~ onDestroy() ~~~")
        super.onDestroy()
    }

    override fun onStart() {
        Timber.i("~~~ onStart() ~~~")
        super.onStart()
    }

    override fun onStop() {
        Timber.i("~~~ onStop() ~~~")
        super.onStop()
    }

    override fun onResume() {
        Timber.i("~~~ onResume() ~~~")
        super.onResume()
    }

    override fun onPause() {
        Timber.i("~~~ onPause() ~~~")
        super.onPause()
    }

    /**
     * The onTopResumedActivityChanged(isTopResumedActivity: Boolean) method is a lifecycle callback
     * in Android introduced for multi-window environments. It notifies when your activity becomes or
     * stops being the "top resumed" activity—meaning the activity that is currently interacting with
     * the user. This is useful for handling UI or resource changes when your activity gains or loses
     * top focus, especially in split-screen or picture-in-picture modes.
     */
    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Timber.i("~~~ onTopResumedActivityChanged(); isTopResumed: $isTopResumedActivity  ~~~")
    }


}