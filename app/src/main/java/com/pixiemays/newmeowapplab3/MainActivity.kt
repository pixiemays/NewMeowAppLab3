package com.pixiemays.newmeowapplab3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            loadFragment(FirstFragment())
        }

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_fragment1 -> {
                    loadFragment(FirstFragment())
                    true
                }
                R.id.nav_fragment2 -> {
                    loadFragment(SecondFragment())
                    true
                }
                R.id.nav_fragment3 -> {
                    loadFragment(ThirdFragment())
                    true
                }
                else -> false
            }
        }

        bottomNav.selectedItemId = R.id.nav_fragment1
    }

    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        val fm = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.commit()
    }
}