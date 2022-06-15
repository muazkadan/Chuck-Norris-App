package net.muazkadan.chucknorris.domain.decider

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class DateFormatter @Inject constructor() {

    fun formatStringDate(date: String?): String {
        if (date == null) return ""
        return try {
            val dateToFormat =
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS", Locale.getDefault()).parse(date)
            val df1: DateFormat = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())
            df1.format(dateToFormat as Date).orEmpty()
        } catch (e: ParseException) {
            e.printStackTrace()
            ""
        }
    }

    fun dateToSting(date: Date?): String {
        if (date == null) return ""
        val format = DATE_FORMAT
        return format.format(date)
    }

    companion object {
        const val DATE_FORMAT = "dd/MM/yyy"
    }
}
