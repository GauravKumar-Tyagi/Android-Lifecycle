package com.gaurav.learn.kotlin.android.lifecycles

import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {

    private val TITLE_KEY: String = "titleKey"
    private val MESSAGE_KEY: String = "messageKey"

    private var mTitle: String? = null
    private var mMessage: String? = null

    private var mCancelButton: Button? = null
    private var mOkButton: Button? = null
    private var description: TextView? = null
    private var title: TextView? = null

    companion object {
        const val TAG: String = "MyDialogFragmentTag"
    }

    override fun onStart() {
        super.onStart()
        this.dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    fun newInstance(
        title: String,
        message: String
    ): MyDialogFragment {
        val dialog: MyDialogFragment = MyDialogFragment()
        dialog.mTitle = title
        dialog.mMessage = message
        return dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        if (savedInstanceState != null) {
            mTitle = savedInstanceState.getString(TITLE_KEY)
            mMessage = savedInstanceState.getString(MESSAGE_KEY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TITLE_KEY, mTitle)
        outState.putString(MESSAGE_KEY, mMessage)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)


        val v: View = inflater.inflate(R.layout.layout_dialog_fragment, container, false)

        mCancelButton = v.findViewById<View>(R.id.button_cancel) as Button
        mOkButton = v.findViewById<View>(R.id.button_ok) as Button
        description = v.findViewById<View>(R.id.textview_description) as TextView
        title = v.findViewById<View>(R.id.textview_Title) as TextView

        description?.text = mMessage
        title?.text = mTitle

        mCancelButton?.setOnClickListener {
            Toast.makeText(requireContext(), "Cancel clicked", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        mOkButton?.setOnClickListener {
            Toast.makeText(requireContext(), "OK clicked", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return v

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                Toast.makeText(requireContext(), "Back pressed in dialog", Toast.LENGTH_SHORT).show()
                dismiss()
                true // consume event
            } else {
                false
            }
        }
        return dialog
    }

}