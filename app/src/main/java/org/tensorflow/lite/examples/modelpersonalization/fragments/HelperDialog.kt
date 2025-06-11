package org.tensorflow.lite.examples.modelpersonalization.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import org.tensorflow.lite.examples.modelpersonalization.R

class HelperDialog : AppCompatDialogFragment() {
    companion object {
        const val TAG = "Helper Dialog"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity()).apply {
            setTitle(requireActivity().getString(R.string.helper_dialog_title))
            setMessage(
                requireActivity().getString(
                    R.string
                        .helper_dialog_content
                )
            )
            setPositiveButton("ok") { _, _ ->
                // no-op
            }
        }.create()
    }
}
