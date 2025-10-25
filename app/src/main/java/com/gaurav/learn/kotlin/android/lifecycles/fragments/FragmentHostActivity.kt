package com.gaurav.learn.kotlin.android.lifecycles.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gaurav.learn.kotlin.android.lifecycles.R
import timber.log.Timber

/**
 * WE CAN NOT HAVE ANY CONSTRUCTOR FOR OUR ACTIVITY
 * EVEN WE CAN NOT HAVE DEFAULT NON-PARAMETERIZED CONSTRUCTOR FOR OUR ACTIVITY
 */
class FragmentHostActivity : AppCompatActivity() {

    private lateinit var btnAddRemoveFragment: Button

    private var isFragmentAdded = false

    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.i("~~~ onCreate() ~~~")

        super.onCreate(savedInstanceState)

        isFragmentAdded = savedInstanceState?.getBoolean("isFragmentAdded", false) ?: false

        setContentView(R.layout.activity_fragment_host)

        btnAddRemoveFragment = findViewById(R.id.btnAddRemoveFragment)

        btnAddRemoveFragment.setOnClickListener {
            if (isFragmentAdded) {
                Timber.i("~~~ Button clicked: remove Fragment ~~~")
                removeFragment()
            } else {
                Timber.i("~~~ Button clicked: add Fragment ~~~")
                addFragment()
            }
            isFragmentAdded = !isFragmentAdded
            updateButtonText()
        }

        updateButtonText()
    }

    private fun updateButtonText() {
        if (isFragmentAdded) {
            btnAddRemoveFragment.text = getString(R.string.remove_fragment)
        } else {
            btnAddRemoveFragment.text = getString(R.string.add_fragment)
        }
    }

    private fun addFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, Fragment1.newInstance(), "fragmentTag")
            .commit()
    }

    private fun removeFragment() {
        supportFragmentManager
            .beginTransaction()
            .remove(supportFragmentManager.findFragmentByTag("fragmentTag")!!)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("~~~ onSaveInstanceState()  outState=> $outState  ~~~ ")
        outState.putBoolean("isFragmentAdded", isFragmentAdded)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Timber.i("~~~ onRestoreInstanceState()  savedInstanceState=> $savedInstanceState  ~~~ ")
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
        Timber.e("~~~ FragmentHostActivity onTopResumedActivityChanged(); isTopResumed: $isTopResumedActivity  ~~~ ")
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, FragmentHostActivity::class.java)
            context.startActivity(intent)
        }
    }
}