package net.muazkadan.chucknorris.presentation.home.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.muazkadan.chucknorris.databinding.ItemJokeBinding
import net.muazkadan.chucknorris.domain.uimodel.JokeUIModel

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class JokeViewHolder(
    parent: ViewGroup,
    inflater: LayoutInflater,
    private val callback: JokeAdapter.JokeClickCallBack,
    private val binding: ItemJokeBinding = ItemJokeBinding.inflate(inflater, parent, false)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(uiModel: JokeUIModel) = with(binding) {
        tvJoke.text = uiModel.value
        chipCategory.text = uiModel.categories
        ivShare.setOnClickListener {
            callback.onShareJokeClick(uiModel.value)
        }
    }
}
