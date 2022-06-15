package net.muazkadan.chucknorris.utils.extensions

import android.content.Context
import android.util.DisplayMetrics

/**
 * @author muaz
 * Created on 6/15/2022.
 */
fun Int.dpToPx(context: Context): Int {
    val displayMetrics = context.resources.displayMetrics
    return this * (displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}
