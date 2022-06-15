package net.muazkadan.chucknorris.domain.usecase

import net.muazkadan.chucknorris.data.repository.JokeRepository
import javax.inject.Inject

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class GetCategoriesUseCase @Inject constructor(
    private val repository: JokeRepository
) {

    suspend operator fun invoke() = repository.getCategories()
}
