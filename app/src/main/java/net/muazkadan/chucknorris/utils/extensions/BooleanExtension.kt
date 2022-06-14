package net.muazkadan.chucknorris.utils.extensions

/**
 * @author muaz
 * Created on 6/14/2022.
 */
val Boolean?.orFalse: Boolean
    get() = this ?: false
