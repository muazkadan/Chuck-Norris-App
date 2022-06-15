package net.muazkadan.chucknorris.utils.extensions

import java.util.Locale

/**
 * @author muaz
 * Created on 6/15/2022.
 */
val String.capitalizeWords
    get() = this.lowercase().split(" ").joinToString(" ") { string ->
        string.replaceFirstChar { char ->
            if (char.isLowerCase()) char.titlecase(
                Locale.getDefault()
            ) else char.toString()
        }
    }
