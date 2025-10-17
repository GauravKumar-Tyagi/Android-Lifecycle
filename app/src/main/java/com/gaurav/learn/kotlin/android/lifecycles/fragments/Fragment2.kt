package com.gaurav.learn.kotlin.android.lifecycles.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.gaurav.learn.kotlin.android.lifecycles.R
import timber.log.Timber

class Fragment2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("~~~ onCreate() ~~~ ")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("~~~ onCreateView() ~~~ ")

        val rootView = layoutInflater.inflate(R.layout.fragment_2, container, false).apply {
            findViewById<Button>(R.id.btnPreviousFragment).setOnClickListener {
                Timber.i("~~~ Button clicked: previous Fragment ~~~ ")
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.i("~~~ onViewCreated() ~~~ ")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Timber.i("~~~ onStart() ~~~ ")
        super.onStart()
    }

    override fun onResume() {
        Timber.i("~~~ onResume() ~~~ ")
        super.onResume()
    }

    override fun onPause() {
        Timber.i("~~~ onPause() ~~~ ")
        super.onPause()
    }

    override fun onStop() {
        Timber.i("~~~ onStop() ~~~ ")
        super.onStop()
    }

    override fun onDestroyView() {
        Timber.i("~~~ onDestroyView() ~~~ ")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Timber.i("~~~ onDestroy() ~~~ ")
        super.onDestroy()
    }

    companion object {
        fun newInstance(): Fragment2 {
            return Fragment2()
        }
    }
}