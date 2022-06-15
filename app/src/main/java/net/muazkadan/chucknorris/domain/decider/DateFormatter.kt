package net.muazkadan.chucknorris.domain.decider

import java.util.Date
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class DateFormatter @Inject constructor() {

    fun dateToSting(date: Date?): String {
        if (date == null) return ""
        val format = DATE_FORMAT
        return format.format(date)
    }

    companion object {
        const val DATE_FORMAT = "dd/MM/yyy"
    }
}
