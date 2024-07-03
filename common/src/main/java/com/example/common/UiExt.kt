package com.example.common

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar

fun View.hideKeyboard() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(windowToken, 0)

}

fun View.showSnackbarError(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show()
}
