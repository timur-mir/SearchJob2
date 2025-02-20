package home.product.searchjob2

import android.content.Context
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import com.google.android.play.core.splitcompat.SplitCompat
//import androidx.navigation.ui.setupWithNavController
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
                        navController.navigate(home.product.navigations.R.id.favoriteFragment)
                    }
                }


                R.id.responsesFragmentB -> {

                }

                R.id.messageFragmentB -> {

                }

                R.id.profileFragmentB -> {

                }
            }
            true
        }
    }
}

