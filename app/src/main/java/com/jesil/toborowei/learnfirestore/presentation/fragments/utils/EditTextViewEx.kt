package com.jesil.toborowei.learnfirestore.presentation.fragments.utils

import android.util.Patterns
import androidx.core.content.MimeTypeFilter.matches
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.regex.Pattern.matches

fun TextInputEditText.validateEmail(
    validate: () -> Unit,
    secondValidate: () -> Unit,
    denied: () -> Unit
) {
    val emailPattern =
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    doOnTextChanged { text, _, _, _ ->
        when {
            emailPattern.toRegex()
                    validateEmailPattern
                    text.toString().trim() -> denied()

            text!!.trim().isEmpty() -> secondValidate()

            else -> validate()
        }
    }
    doAfterTextChanged {
        when {
            emailPattern.toRegex()
                    validateEmailPattern
                    text.toString().trim() -> denied()

            text!!.trim().isEmpty() -> secondValidate()

            else -> validate()
        }
    }
}

fun TextInputEditText.validatePassword(
    validate: () -> Unit,
    secondValidate: () -> Unit,
    denied: () -> Unit
) {
    doOnTextChanged { text, _, _, _ ->
        when {
            text!!.isEmpty() -> validate()

            text.trim().length < 5 -> secondValidate()

            else -> denied()
        }
    }
    doAfterTextChanged {
        when {
            text!!.isEmpty() -> validate()

            text!!.trim().length < 5 -> secondValidate()

            else -> denied()
        }
    }
}

private infix fun Regex.validateEmailPattern(email: String): Boolean =
    Pattern.compile(this.toString()).matcher(email).matches()

