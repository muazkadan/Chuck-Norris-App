package net.muazkadan.chucknorris.presentation.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class CategoryAdapter(private val callback: CategoryClickCallBack) :
    ListAdapter<String, CategoryViewHolder>(object : DiffUtil.ItemCallback<String?>() {
        override fun areItemsTheSame(old: String, new: String): Boolean = old === new
        override fun areContentsTheSame(old: String, new: String): Boolean = old == new
    }) {

    interface CategoryClickCallBack {
        fun onClickCategory(category: String)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder =
        CategoryViewHolder(parent, LayoutInflater.from(parent.context), callback)

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
