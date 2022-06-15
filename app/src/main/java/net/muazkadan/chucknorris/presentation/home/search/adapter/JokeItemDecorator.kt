package net.muazkadan.chucknorris.presentation.home.search.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import net.muazkadan.chucknorris.utils.extensions.dpToPx

/**
 * @author muaz
 * Created on 6/15/2022.
 */

private const val ITEM_TOP_MARGIN = 14
private const val ITEM_HORIZONTAL_MARGIN = 14
private const val ITEM_BOTTOM_MARGIN = 12

class JokeItemDecorator(context: Context) : RecyclerView.ItemDecoration() {

    private val marginTop by lazy {
        ITEM_TOP_MARGIN.dpToPx(
            context
        )
    }

    private val marginHorizontal by lazy {
        ITEM_HORIZONTAL_MARGIN.dpToPx(context)
    }

    private val marginBottom by lazy {
        ITEM_BOTTOM_MARGIN.dpToPx(context)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val itemPosition = parent.getChildAdapterPosition(view)
        if (itemPosition == 0) {
            outRect.top = marginTop
        }
        outRect.left = marginHorizontal
        outRect.right = marginHorizontal
        outRect.bottom = marginBottom
    }
}
