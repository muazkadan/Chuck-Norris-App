package net.muazkadan.chucknorris.utils.extensions

import android.content.Context
import android.widget.Toast

/**
 * @author muaz
 * Created on 6/15/2022.
 */

/**
 * Extension for showing Toast
 * @param message message to be shown on screen
 * @param showLong to show long toast when true
 */
fun Context?.toast(message: String?, showLong: Boolean = true) {
    if (this != null && message.isNullOrEmpty().not()) {
        Toast.makeText(
            this,
            message,
            if (showLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        ).show()
    }
}
