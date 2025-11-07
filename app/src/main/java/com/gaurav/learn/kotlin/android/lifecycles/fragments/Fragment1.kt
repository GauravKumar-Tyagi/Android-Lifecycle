package com.gaurav.learn.kotlin.android.lifecycles.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.gaurav.learn.kotlin.android.lifecycles.MyDialogFragment
import com.gaurav.learn.kotlin.android.lifecycles.R
import timber.log.Timber

/**
 * In Android, fragments should have only a public no-argument constructor.
 * This is required so the system can instantiate the fragment as needed
 * (e.g., during configuration changes or process recreation).
 * If you need to pass data to a fragment, use a Bundle with setArguments()
 * and retrieve it in onCreate() or onCreateView().
 * NOTE:
 * Do not use custom constructors with parameters for fragments
 * i.e. DO NOT USE PARAMETERIZED CONSTRUCTOR FOR FRAGMENTS
 * AND USE ONLY DEFAULT NON-PARAMETERIZED CONSTRUCTOR FOR FRAGMENTS.
 */
class Fragment1 : Fragment() {

    private var rootView: View? = null

    /**
     * Called when the fragment is first created.
     * The savedInstanceState bundle can be used
     * to restore the fragment's state if it was previously destroyed.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("~~~ onCreate() ~~~ ")
        super.onCreate(savedInstanceState)
    }

    /**
     * Called to create the fragment’s view hierarchy.
     * Return the root view of the fragment’s layout.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.i("~~~ onCreateView() ~~~ ")

        if (rootView == null) {
            Timber.i("~~~ initializing the view hierarchy ~~~ ")
            rootView = layoutInflater.inflate(R.layout.fragment_1, container, false).apply {
                findViewById<Button>(R.id.btnNextFragment).setOnClickListener {
                    Timber.i("~~~ Button clicked: Replace next Fragment ~~~ ")
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, Fragment2.newInstance(), "fragmentTag")
                        .addToBackStack(null)
                        .commit()
                }
                findViewById<Button>(R.id.btnAddNextFragment).setOnClickListener {
                    Timber.i("~~~ Button clicked: Add next Fragment ~~~ ")
                    requireActivity().supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragmentContainer, Fragment2.newInstance(), "fragmentTag")
                        .addToBackStack(null)
                        .commit()
                }

                findViewById<Button>(R.id.btnDialogFragment).setOnClickListener {
                    val dialog = MyDialogFragment().newInstance("Dialog Title", "Dialog message")
                    dialog.show(childFragmentManager, MyDialogFragment.TAG)
                }

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

    /**
     * Called when the fragment’s view hierarchy is being destroyed.
     * Clean up any resources associated with the view.
     */
    override fun onDestroyView() {
        Timber.i("~~~ onDestroyView() ~~~ ")
        super.onDestroyView()
    }

    /**
     * Called when the fragment is being destroyed.
     * Perform any cleanup that needs to be done before the fragment is destroyed.
     */
    override fun onDestroy() {
        Timber.i("~~~ onDestroy() ~~~ ")
        super.onDestroy()
    }

    companion object {
        fun newInstance(): Fragment1 {
            return Fragment1()
        }
    }

    /**
     * Called when the fragment is attached to its activity.
     * You can use this method to retrieve references
     * to the activity or its resources.
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("~~~ onAttach() ~~~ ")
    }

    /**
     * Called after the fragment’s activity has finished its onCreate() method.
     * You can use this method to interact with the activity or its views.
     * NOTE: It has been Deprecated now.
     */
    @Deprecated("Deprecated")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("~~~ onActivityCreated() ~~~ ")
    }

    /**
     * Called when the fragment is detached from its activity.
     * Clean up any references to the activity.
     */
    override fun onDetach() {
        super.onDetach()
        Timber.i("~~~ onDetach() ~~~ ")
    }

}