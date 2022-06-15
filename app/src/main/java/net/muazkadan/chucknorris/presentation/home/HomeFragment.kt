package net.muazkadan.chucknorris.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.muazkadan.chucknorris.R
import net.muazkadan.chucknorris.databinding.FragmentHomeBinding
import net.muazkadan.chucknorris.utils.extensions.setImageUrlWithProgress
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun initViews() = with(binding) {
        ivLogo.setImageUrlWithProgress(getString(R.string.cn_logo_link), R.drawable.cn_logo)
    }

    private fun observe() = with(viewModel) {
    }
}
