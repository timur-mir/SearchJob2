package home.product.searchjob2

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import home.product.navigations.navigate
import home.product.searchjob2.BottomPanel.panelNav

import home.product.searchjob2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNavigationView = binding.panelNavigationMain
        val navController = findNavController(home.product.navigations.R.id.frag_cont)
        bottomNavigationView.setupWithNavController(navController)
        panelNav = bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.searchFragment ->
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment

                    ) {
                    } else {
                        if (navController.currentDestination!!.id == home.product.vacancies.R.id.favoriteFragment ||
                            navController.currentDestination!!.id == home.product.vacancies.R.id.responsesFragment ||
                            navController.currentDestination!!.id == home.product.vacancies.R.id.messageFragment ||
                            navController.currentDestination!!.id == home.product.vacancies.R.id.profileFragment
                        ) {
                            navController.setGraph(R.navigation.navigation_global)
                            navController.navigate(R.id.searchFragment)
                        } else {
                            navController.navigate(R.id.searchFragment)
                        }
                    }


                R.id.favoriteFragment -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(home.product.vacancies.R.navigation.search_vacancies_navigation)
                        navController.navigate(home.product.vacancies.R.id.favoriteFragment)
                    }
                }

                R.id.responsesFragment -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(home.product.vacancies.R.navigation.search_vacancies_navigation)
                        navController.navigate(home.product.vacancies.R.id.responsesFragment)
                    }
                }

                R.id.messageFragment -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(home.product.vacancies.R.navigation.search_vacancies_navigation)
                        navController.navigate(home.product.vacancies.R.id.messageFragment)
                    }
                }

                R.id.profileFragment -> {
                    if (navController.currentDestination!!.id == R.id.mainLoginFragment) {
                    } else {
                        navController.setGraph(home.product.vacancies.R.navigation.search_vacancies_navigation)
                        navController.navigate(home.product.vacancies.R.id.profileFragment)
                    }
                }
            }
            true
        }
    }
}

object BottomPanel {
    lateinit var panelNav: BottomNavigationView
}
