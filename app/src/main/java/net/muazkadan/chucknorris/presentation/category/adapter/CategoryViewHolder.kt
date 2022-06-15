package net.muazkadan.chucknorris.presentation.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.muazkadan.chucknorris.databinding.ItemCategoryBinding
import net.muazkadan.chucknorris.utils.extensions.capitalizeWords

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class CategoryViewHolder(
    parent: ViewGroup,
    inflater: LayoutInflater,
    private val callback: CategoryAdapter.CategoryClickCallBack,
    private val binding: ItemCategoryBinding = ItemCategoryBinding.inflate(inflater, parent, false)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(uiModel: String) = with(binding) {
        tvCategory.text = uiModel.capitalizeWords
        itemView.setOnClickListener {
            callback.onClickCategory(uiModel)
        }
    }
}
