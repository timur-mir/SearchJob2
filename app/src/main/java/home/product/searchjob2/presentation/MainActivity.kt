package home.product.searchjob2.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import home.product.searchjob2.App
import home.product.searchjob2.MainObject.addingElement
import home.product.searchjob2.R
import home.product.searchjob2.databinding.ActivityMainBinding
import home.product.searchjob2.di.DaggerAppComponent
import home.product.searchjob2.presentation.MainActivity.helpScopeReference3.addElement
import home.product.searchjob2.presentation.MainActivity.helpScopeReference3.bottomNavigationViewMainReference
import home.product.searchjob2.presentation.MainActivity.helpScopeReference3.elementDelete
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var headViewModel: HeadViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerAppComponent.builder().coreComponent(
            App.coreComponent(this)
        ).build().inject2(this)

        val bottomNavigationView = binding.panelNavigationMain
        bottomNavigationViewMainReference = binding.panelNavigationMain
        val navController = findNavController(home.product.navigations.R.id.frag_cont)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.searchFragmentB -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment ||
                        navController.currentDestination!!.id == home.product.authorization.R.id.authorizationFragment ||
                        navController.currentDestination!!.id == home.product.authorization.R.id.confirmationFragment
                    ) {
                    } else {
                        navController.setGraph(R.navigation.navigation_global)
                        navController.navigate(home.product.navigations.R.id.searchFragment)
                    }
                }


                R.id.favoriteFragmentB -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(R.navigation.navigation_global)
                        navController.navigate(home.product.navigations.R.id.favoriteMainFragment)
                    }
                }


                R.id.responsesFragmentB -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(R.navigation.navigation_global)
                        navController.navigate(home.product.navigations.R.id.responsesFragment)
                    }
                }

                R.id.messageFragmentB -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(R.navigation.navigation_global)
                        navController.navigate(home.product.navigations.R.id.messageFragment)
                    }
                }

                R.id.profileFragmentB -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(R.navigation.navigation_global)
                        navController.navigate(home.product.navigations.R.id.profileFragment)
                    }
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()

        headViewModel.loadFavoriteVacancies()
        headViewModel.responseVacancies.observe(this@MainActivity) { list ->
            if (elementDelete) {
                val menuItemId = binding.panelNavigationMain.menu.getItem(1).itemId
                val badge = binding.panelNavigationMain.getOrCreateBadge(menuItemId)
                if (addingElement == 0||addingElement<0) {
                    badge.isVisible = false
                } else {
                    badge.isVisible = true
                    badge.number = addingElement
                }
            }
            if (addElement) {
                val menuItemId = binding.panelNavigationMain.menu.getItem(1).itemId
                val badge = binding.panelNavigationMain.getOrCreateBadge(menuItemId)
                if (addingElement == 0) {
                    badge.isVisible = false
                }
                else
                {
                    badge.isVisible = true
                    badge.number = addingElement
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    object helpScopeReference3 {
        var elementDelete = false
        var addElement = false
        lateinit var bottomNavigationViewMainReference: BottomNavigationView
    }
}

