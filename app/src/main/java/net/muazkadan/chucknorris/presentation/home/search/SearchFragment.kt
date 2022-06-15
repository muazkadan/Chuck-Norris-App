package net.muazkadan.chucknorris.presentation.home.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.R
import net.muazkadan.chucknorris.databinding.FragmentSearchBinding
import net.muazkadan.chucknorris.presentation.home.search.adapter.JokeAdapter
import net.muazkadan.chucknorris.presentation.home.search.adapter.JokeItemDecorator
import net.muazkadan.chucknorris.utils.extensions.toast
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/15/2022.
 */
@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search), JokeAdapter.JokeClickCallBack {

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()

    private val args: SearchFragmentArgs by navArgs()

    private val query get() = args.query

    private val adapter by lazy {
        JokeAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
        viewModel.getJokes(query)
    }

    private fun initViews() = with(binding) {
        initSearchBox()
        rvJokes.adapter = adapter
        rvJokes.addItemDecoration(JokeItemDecorator(requireContext()))
    }

    private fun initSearchBox() = with(binding.searchBox) {
        setOnBackClickListener {
            findNavController().popBackStack()
        }
        text = query
        setTextWatcher()
        onBtnSearchClickListener {
            viewModel.getJokes(binding.searchBox.text)
        }
    }

    private fun observe() = with(viewModel) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiState.collect {
                        binding.tvMessage.isVisible = it.jokesList.isEmpty()
                        adapter.submitList(it.jokesList)
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

    override fun onShareJokeClick(joke: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, joke)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}
