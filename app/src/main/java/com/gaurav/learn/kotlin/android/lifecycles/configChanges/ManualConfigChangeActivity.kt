package com.gaurav.learn.kotlin.android.lifecycles.configchanges

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gaurav.learn.kotlin.android.lifecycles.R
import timber.log.Timber

/**
 * 1. You can disable the default config change flow (OR disable automatic destroy-recreate flow) in
 *    specific Activities by setting their android:configChanges attribute in the manifest.
 * 2. When config changes will take place, Activities (and Fragments) that handle them manually
 *    won’t get calls to any of the standard lifecycle methods.
 * 3. Instead, onConfigurationChanged will be called in Activities and Fragments to allow them
 *    adjusting to the new configuration.
 * 4. Risky approach, so use with caution.
 */
class ManualConfigChangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.i("~~~ onCreate() ~~~ ")

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_manual_config_change)

    }

    override fun onDestroy() {
        Timber.i("~~~ onDestroy() ~~~ ")
        super.onDestroy()
    }

    override fun onStart() {
        Timber.i("~~~ onStart() ~~~ ")
        super.onStart()
    }

    override fun onStop() {
        Timber.i("~~~ onStop() ~~~ ")
        super.onStop()
    }

    override fun onResume() {
        Timber.i("~~~ onResume() ~~~ ")
        super.onResume()
    }

    override fun onPause() {
        Timber.i("~~~ onPause() ~~~ ")
        super.onPause()
    }

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Timber.e("~~~ onTopResumedActivityChanged(); isTopResumed: $isTopResumedActivity  ~~~ ")
    }

    /**
     * onConfigurationChanged is called when the device configuration
     * changes (like orientation, locale, or screen size) and your activity
     * has declared to handle those changes in the manifest.
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        Timber.i("~~~ onConfigurationChanged() ~~~ ")
        super.onConfigurationChanged(newConfig)

        val textView = findViewById<TextView>(R.id.textView)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            textView.text = getString(R.string.landscape_mode)
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            textView.text = getString(R.string.portrait_mode)
        }
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, ManualConfigChangeActivity::class.java)
            context.startActivity(intent)
        }
    }

}