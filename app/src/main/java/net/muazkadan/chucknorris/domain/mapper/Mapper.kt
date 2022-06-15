package net.muazkadan.chucknorris.domain.mapper

/**
 * @author muaz
 * Created on 6/15/2022.
 */
interface Mapper <in Input, out Output> {
    fun map(input: Input): Output
}
