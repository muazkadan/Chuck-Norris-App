package net.muazkadan.chucknorris

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import dagger.hilt.android.AndroidEntryPoint
import net.muazkadan.chucknorris.databinding.ActivityMainBinding
import net.muazkadan.chucknorris.utils.extensions.orFalse
import net.muazkadan.chucknorris.utils.extensions.setupWithNavController
import net.muazkadan.chucknorris.utils.viewBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var currentNavController: LiveData<NavController>? = null
    private val navGraphIds = listOf(
        R.navigation.nav_home,
        R.navigation.nav_category
    )

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )

        controller.observe(this) { navController ->
            navController.addOnDestinationChangedListener { _, destination, _ ->
                handleNavDestination(destination)
            }
        }
        currentNavController = controller
    }

    private fun handleNavDestination(destination: NavDestination) {
        when (destination.id) {
            R.id.splashFragment,
            R.id.searchFragment -> {
                binding.bottomNav.isVisible = false
            }
            else -> {
                binding.bottomNav.isVisible = true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp().orFalse
    }
}
