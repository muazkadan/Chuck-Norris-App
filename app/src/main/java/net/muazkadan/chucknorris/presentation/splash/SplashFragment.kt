package net.muazkadan.chucknorris.presentation.splash

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.muazkadan.chucknorris.R
import net.muazkadan.chucknorris.databinding.FragmentSplashBinding
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/14/2022.
 */
@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels()
}
