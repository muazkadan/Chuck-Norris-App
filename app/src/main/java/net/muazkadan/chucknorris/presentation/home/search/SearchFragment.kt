package net.muazkadan.chucknorris.presentation.home.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import net.muazkadan.chucknorris.R
import net.muazkadan.chucknorris.databinding.FragmentSearchBinding
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/15/2022.
 */
@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()

    private val args: SearchFragmentArgs by navArgs()

    private val query get() = args.query

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun initViews() = with(binding) {
        initSearchBox()
    }

    private fun initSearchBox() = with(binding.searchBox) {
        setOnBackClickListener {
            findNavController().popBackStack()
        }
        text = query
        setTextWatcher()
    }

    private fun observe() = with(viewModel) {
    }
}
