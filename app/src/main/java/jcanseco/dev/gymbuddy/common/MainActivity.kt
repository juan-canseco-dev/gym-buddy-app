package jcanseco.dev.gymbuddy.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jcanseco.dev.gymbuddy.router.RouterState
import jcanseco.dev.gymbuddy.router.RouterViewModel
import jcanseco.dev.gymbuddy.databinding.ActivityMainBinding
import jcanseco.dev.gymbuddy.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val navController by lazy { findNavController(R.id.nav_host_fragment)}

    private val routerViewModel : RouterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        routerViewModel.routerState.observe(this, this::handleRouterState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                return@setKeepOnScreenCondition routerViewModel.loading.value == true
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun handleRouterState(state : RouterState?) {

    }
}