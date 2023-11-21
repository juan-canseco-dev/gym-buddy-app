package jcanseco.dev.gymbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import jcanseco.dev.gymbuddy.router.RouterState
import jcanseco.dev.gymbuddy.router.RouterViewModel
import jcanseco.dev.gymbuddy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

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
        state.let {
            when (it) {
                is RouterState.UserAuthenticated -> {
                    Log.d("TAG1", "User Authenticated")
                }
                is RouterState.UserAuthenticatedWithProfileIncomplete -> {

                }
                is RouterState.UserUnauthenticated -> {

                }
                else -> {

                }
            }
        }
    }
}