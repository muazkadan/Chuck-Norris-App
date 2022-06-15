package net.muazkadan.chucknorris.presentation.home.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import net.muazkadan.chucknorris.domain.uimodel.JokeUIModel

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class JokeAdapter(private val callback: JokeClickCallBack) :
    ListAdapter<JokeUIModel, JokeViewHolder>(object : DiffUtil.ItemCallback<JokeUIModel?>() {
        override fun areItemsTheSame(old: JokeUIModel, new: JokeUIModel): Boolean = old.id == new.id
        override fun areContentsTheSame(old: JokeUIModel, new: JokeUIModel): Boolean = old == new
    }) {

    interface JokeClickCallBack {
        fun onShareJokeClick(joke: String)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JokeViewHolder = JokeViewHolder(parent, LayoutInflater.from(parent.context), callback)

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
