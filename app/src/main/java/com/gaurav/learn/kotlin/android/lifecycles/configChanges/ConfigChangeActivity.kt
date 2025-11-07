package com.gaurav.learn.kotlin.android.lifecycles.configchanges

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gaurav.learn.kotlin.android.lifecycles.R
import timber.log.Timber

class ConfigChangeActivity : AppCompatActivity(), ConfigChangeFragment.Listener {

    private lateinit var txtUserInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.i("~~~ onCreate() ~~~ ")

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_config_change)

        txtUserInput = findViewById(R.id.txtUserInput)

        onUserInputChanged("")

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, ConfigChangeFragment.newInstance(), "fragmentTag")
                .commit()
        }

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

    override fun onUserInputChanged(userInput: String) {
        txtUserInput.text = "User input: $userInput"
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, ConfigChangeActivity::class.java)
            context.startActivity(intent)
        }
    }

}