package net.muazkadan.chucknorris.domain.decider

import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class CategoriesDecider @Inject constructor() {

    fun getCategoriesStringList(categories: List<String>): String {
        return categories.joinToString(", ")
    }
}
