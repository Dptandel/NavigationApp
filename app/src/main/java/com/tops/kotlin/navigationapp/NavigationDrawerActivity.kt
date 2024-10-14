package com.tops.kotlin.navigationapp

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tops.kotlin.navigationapp.databinding.ActivityNavigationDrawerBinding
import com.tops.kotlin.navigationapp.fragments.HomeFragment
import com.tops.kotlin.navigationapp.fragments.SettingsFragment

class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationDrawerBinding

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // add toggle button to drawer
        /*toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.appBarLayout.toolbar, R.string.open, R.string.close
        )

        toggle.drawerArrowDrawable.color = resources.getColor(R.color.white)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)*/

        binding.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        loadFragment(HomeFragment())

        // set navigation item selected listener
        binding.navigationView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                }

                R.id.settings -> {
                    loadFragment(SettingsFragment())
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}