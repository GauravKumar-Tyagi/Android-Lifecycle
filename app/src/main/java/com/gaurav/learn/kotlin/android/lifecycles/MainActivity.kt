package com.gaurav.learn.kotlin.android.lifecycles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gaurav.learn.kotlin.android.lifecycles.configchanges.ConfigChangeActivity
import com.gaurav.learn.kotlin.android.lifecycles.configchanges.ManualConfigChangeActivity
import com.gaurav.learn.kotlin.android.lifecycles.fragments.FragmentHostActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

    fun startFragmentHostActivity(view: View) {
        FragmentHostActivity.start(this@MainActivity)
    }

    fun startConfigChangeActivity(view: View) {
        ConfigChangeActivity.start(this@MainActivity)
    }

    fun startManualConfigChangeActivity(view: View) {
        ManualConfigChangeActivity.start(this@MainActivity)
    }

    fun showAlertDialog(view: View) {
        showAlertDialog(this)
    }

    fun showDialogFragment(view: View) {
        val dialog = MyDialogFragment().newInstance("Dialog Title", "Dialog message")
        dialog.show(supportFragmentManager, MyDialogFragment.TAG)
    }

    fun showSystemDialog1(view: View) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            //type = "*/*"    // Imp. => or specify a MIME type like "image/*"
            type = "image/*" // Imp. => or specify a MIME type like "*/*"
        }
        startActivityForResult(intent, 1001)
    }

    fun showSystemDialog2(view: View) {
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Hello from my app!")
        }
        val chooser = Intent.createChooser(sendIntent, "Choose an app")
        startActivity(chooser)

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
        Timber.e("~~~ onTopResumedActivityChanged(); isTopResumed: $isTopResumedActivity  ~~~")
    }


    private fun showAlertDialog(context: Context) {
        MaterialAlertDialogBuilder(context)
            .setTitle(getString(R.string.alert_title))
            .setMessage(getString(R.string.alert_dialog_message))
            .setCancelable(false)
            .setNegativeButton(getString(R.string.setting)
            ) { dialog, which ->
                Toast.makeText(context, "Settings clicked $which", Toast.LENGTH_SHORT).show()
                //dialog.dismiss()
            }
            .setPositiveButton(getString(R.string.ok),null)
            .show()
    }


}