package com.trina.energy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.trina.energy.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // to find the nav controller from the nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        //for appbar & drawer layout
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupWithNavController(binding.toolbar, navController)

        setupNavigation()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_menu -> {
                findNavController(R.id.nav_host_fragment_container)
                true
            }
            else -> false
        }
    }

    private fun setupNavigation() {
        navController.addOnDestinationChangedListener { nc: NavController, destination: NavDestination, bundle: Bundle? ->
            when (destination.id) {
                R.id.homeFragment -> {
                    supportActionBar?.show()
                    binding.toolbar.setNavigationIcon(R.drawable.ic_menu_icon)
                }
                else -> {
                    binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                    supportActionBar?.show()
                }
            }
        }

    }

}