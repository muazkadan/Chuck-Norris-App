package net.muazkadan.chucknorris.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.muazkadan.chucknorris.R
import net.muazkadan.chucknorris.databinding.FragmentHomeBinding
import net.muazkadan.chucknorris.presentation.home.dialog.RandomJokeDialog
import net.muazkadan.chucknorris.utils.base.BaseFragment
import net.muazkadan.chucknorris.utils.extensions.setImageUrlWithProgress
import net.muazkadan.chucknorris.utils.extensions.toast
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun initViews() = with(binding) {
        ivLogo.setImageUrlWithProgress(getString(R.string.cn_logo_link), R.drawable.cn_logo)
        btnRandomJoke.setOnClickListener {
            viewModel.getRandomJoke()
        }
    }

    private fun observe() = with(viewModel) {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiEvent.collect { uiEvent ->
                        uiEvent.randomJoke?.run {
                            RandomJokeDialog(requireContext(), this) { joke ->
                                shareJoke(joke)
                            }.show()
                        }
                    }
                }
                launch {
                    loadingState.collect {
                        showOrHideProgressBarDialog(it)
                    }
                }
                launch {
                    errorMessage.collect { message ->
                        message.run(context::toast)
                    }
                }
            }
        }
    }

    private fun shareJoke(sharedText: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, sharedText)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}
