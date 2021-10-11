package com.jesil.toborowei.learnfirestore.presentation.fragments.utils

import android.R
import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputLayout
import com.jesil.toborowei.learnfirestore.databinding.DialogErrorBinding

infix fun Button.enableButton(state: Boolean) {
    isEnabled = state
}

infix fun TextInputLayout.error(errorMsg: String?) {
    error = errorMsg
}

infix fun Context?.showErrorDialog(errorMessage: String?) {
    val root = DialogErrorBinding.inflate(LayoutInflater.from(this))

    val dismissButton = root.dismissButton
    val errorText = root.errorText

    val dialog = AlertDialog.Builder(this)
        .setView(root.root).create()
    dialog.setCancelable(true)

    dialog.window?.setBackgroundDrawable(
        ColorDrawable(
            ContextCompat.getColor(this!!, R.color.transparent)
        )
    )
    errorText.text = errorMessage
    dismissButton.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}

infix fun ProgressBar.showProgress(state: Boolean) {
    isVisible = state
}
