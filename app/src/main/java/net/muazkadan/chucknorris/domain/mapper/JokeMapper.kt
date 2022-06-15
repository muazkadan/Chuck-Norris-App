package net.muazkadan.chucknorris.domain.mapper

import net.muazkadan.chucknorris.data.model.response.JokeResponse
import net.muazkadan.chucknorris.domain.decider.CategoriesDecider
import net.muazkadan.chucknorris.domain.decider.DateFormatter
import net.muazkadan.chucknorris.domain.uimodel.JokeUIModel
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class JokeMapper @Inject constructor(
    private val categoriesDecider: CategoriesDecider,
    private val dateFormatter: DateFormatter
) : Mapper<JokeResponse, JokeUIModel> {

    override fun map(input: JokeResponse): JokeUIModel {
        return JokeUIModel(
            categories = categoriesDecider.getCategoriesStringList(input.categories.orEmpty()),
            createdAt = dateFormatter.dateToSting(input.createdAt),
            iconUrl = input.iconUrl.orEmpty(),
            id = input.id.orEmpty(),
            updatedAt = dateFormatter.dateToSting(input.updatedAt),
            url = input.url.orEmpty(),
            value = input.value.orEmpty()
        )
    }
}
