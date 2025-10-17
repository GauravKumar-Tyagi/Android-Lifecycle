package com.gaurav.learn.kotlin.android.lifecycles

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class SecondActivity : AppCompatActivity() {

    private lateinit var progress: View

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }
    }

    fun startNextActivity(view: View) {
        TransparentActivity.start(this@SecondActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.i("~~~ onCreate() ~~~")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        progress = findViewById<View>(R.id.progress)

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
        if (Build.VERSION.SDK_INT < 29) {
            progress.visibility = View.VISIBLE
        }
    }

    override fun onPause() {
        Timber.i("~~~ onPause() ~~~")
        super.onPause()
        if (Build.VERSION.SDK_INT < 29) {
            progress.visibility = View.GONE
        }
    }

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Timber.e("~~~ onTopResumedActivityChanged(); isTopResumed: $isTopResumedActivity  ~~~")
        if (isTopResumedActivity) {
            progress.visibility = View.VISIBLE
        } else {
            progress.visibility = View.GONE
        }
    }

}