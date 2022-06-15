package net.muazkadan.chucknorris.domain.decider

import org.junit.Before
import org.junit.Test
import java.util.Date

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class DateFormatterTest {

    lateinit var dateFormatter: DateFormatter

    @Before
    fun setUp() {
        dateFormatter = DateFormatter()
    }

    @Test
    fun `when date is null, then expected value is empty string`() {
        // Given
        val date: Date? = null
        // When
        val stringDate = dateFormatter.dateToSting(date)
        // Then
        assert(stringDate == "")
    }
}
