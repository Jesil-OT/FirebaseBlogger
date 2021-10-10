package com.jesil.toborowei.learnfirestore.presentation.fragments.utils

import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

infix fun Button.enableButton(state: Boolean){
    isEnabled = state
}

infix fun TextInputLayout.error(errorMsg : String?){
    error = errorMsg
}