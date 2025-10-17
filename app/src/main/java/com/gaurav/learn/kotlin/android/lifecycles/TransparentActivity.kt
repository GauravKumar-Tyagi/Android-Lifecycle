package com.gaurav.learn.kotlin.android.lifecycles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber


class TransparentActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, TransparentActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.i("~~~ onCreate() ~~~")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transparent)

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

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Timber.e("~~~ onTopResumedActivityChanged(); isTopResumed: $isTopResumedActivity  ~~~")
    }

}