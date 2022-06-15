package net.muazkadan.chucknorris.domain.decider

import org.junit.Before
import org.junit.Test

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class CategoriesDeciderTest {

    lateinit var categoriesDecider: CategoriesDecider

    @Before
    fun setUp() {
        categoriesDecider = CategoriesDecider()
    }

    @Test
    fun `when list is not empty, then expected value is not empty string`() {
        // Given
        val list = listOf("animal", "career", "celebrity")
        // When
        val listToString = categoriesDecider.getCategoriesStringList(list)
        // Then
        assert(listToString == "animal, career, celebrity")
    }

    @Test
    fun `when list is empty, then expected value is UNCATEGORIZED string`() {
        // Given
        val list = listOf<String>()
        // When
        val listToString = categoriesDecider.getCategoriesStringList(list)
        // Then
        assert(listToString == "UNCATEGORIZED")
    }

    @Test
    fun `when list has one element, then expected value is string without comma`() {
        // Given
        val list = listOf("animal")
        // When
        val listToString = categoriesDecider.getCategoriesStringList(list)
        // Then
        assert(listToString == "animal")
    }
}
