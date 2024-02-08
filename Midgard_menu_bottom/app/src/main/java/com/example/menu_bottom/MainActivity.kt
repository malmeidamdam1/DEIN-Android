package com.example.menu_bottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    private fun setupBottomMenu() {
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item -> onItemSelectedListener(item) }
        bottomNavigationView.setSelectedItemId(R.id.page_home)
    }

    private fun onItemSelectedListener(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.page_home -> {
                showPageFragment(R.drawable.ic_home, R.string.bottom_nav_home)
                return true
            }
            R.id.page_fav -> {
                showPageFragment(R.drawable.ic_fav, R.string.bottom_nav_fav)
                return true
            }
            R.id.page_search -> {
                showPageFragment(R.drawable.ic_search, R.string.bottom_nav_search)
                return true
            }
            R.id.page_settings -> {
                showPageFragment(R.drawable.ic_settings, R.string.bottom_nav_settings)
                return true
            }
            else -> throw IllegalArgumentException("Item not implemented: ${item.itemId}")
        }
    }

    private fun showPageFragment(@DrawableRes iconId: Int, @StringRes title: Int) {
        val fragment = PageFragment.newInstance(iconId)
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.bottom_nav_enter, R.anim.bottom_nav_exit)
            .replace(R.id.container, fragment)
            .commit()
    }




}