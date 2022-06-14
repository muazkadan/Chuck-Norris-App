package net.muazkadan.chucknorris.utils.extensions

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import net.muazkadan.chucknorris.di.GlideApp

/**
 * @author muaz
 * Created on 6/14/2022.
 */
fun ImageView.setImageUrl(imageUrl: Any, onError: Any? = null) {
    GlideApp.with(context)
        .load(imageUrl)
        .error(onError)
        .into(this)
}

fun ImageView.setImageUrlWithProgress(
    imageUrl: Any,
    onError: Any? = null
) {
    val circularProgressDrawable = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }

    GlideApp.with(context)
        .load(imageUrl)
        .error(onError)
        .placeholder(circularProgressDrawable)
        .into(this)
}
