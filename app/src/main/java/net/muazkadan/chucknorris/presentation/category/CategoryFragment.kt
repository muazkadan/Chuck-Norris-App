package net.muazkadan.chucknorris.presentation.category

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.R
import net.muazkadan.chucknorris.databinding.FragmentCategoryBinding
import net.muazkadan.chucknorris.presentation.category.adapter.CategoryAdapter
import net.muazkadan.chucknorris.presentation.category.adapter.CategoryItemDecorator
import net.muazkadan.chucknorris.utils.extensions.toast
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@AndroidEntryPoint
class CategoryFragment :
    Fragment(R.layout.fragment_category),
    CategoryAdapter.CategoryClickCallBack {

    private val binding by viewBinding(FragmentCategoryBinding::bind)
    private val viewModel: CategoryViewModel by viewModels()

    private val adapter by lazy {
        CategoryAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun initViews() = with(binding) {
        rvCategory.adapter = adapter
        rvCategory.addItemDecoration(CategoryItemDecorator(requireContext()))
    }

    private fun observe() = with(viewModel) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiState.collect {
                        adapter.submitList(it.categoriesList)
                    }
                }
                launch {
                    loadingState.collect {
                        binding.progressBar.isVisible = it
                    }
                }
                launch {
                    errorMessage.collect { message ->
                        adapter.submitList(emptyList())
                        message.run(context::toast)
                    }
                }
            }
        }
    }

    override fun onClickCategory(category: String) {
        TODO("Not yet implemented")
    }
}
