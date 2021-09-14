package com.trina.energy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.trina.energy.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var navController: NavController
    lateinit var drawer : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // to find the nav controller from the nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        // initialized drawer binding
        drawer =  binding.drawerLayout

        //for appbar & drawer layout
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupWithNavController(binding.toolbar, navController,AppBarConfiguration(navController.graph,drawer))
        setupWithNavController(binding.navview,navController)
        NavigationUI.setupActionBarWithNavController(this,navController,drawer)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupNavigation()

    }

    private fun setupNavigation() {
        navController.addOnDestinationChangedListener { nc: NavController, destination: NavDestination, bundle: Bundle? ->
            when (destination.id) {
                R.id.homeFragment -> {
                    supportActionBar?.show()
                    drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                   // binding.toolbar.setNavigationIcon(R.drawable.ic_menu_icon)
                }
                R.id.notificationFragment ->{
                    supportActionBar?.show()
                    drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

                }
                else -> {
                    supportActionBar?.hide()
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawer)
    }

}