package com.pixiemays.newmeowapplab3

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadFragment(FirstFragment())

        val btn1: Button = findViewById(R.id.btn_fragment1)
        val btn2: Button = findViewById(R.id.btn_fragment2)
        val btn3: Button = findViewById(R.id.btn_fragment3)

        btn1.setOnClickListener {
            loadFragment(FirstFragment())
        }

        btn2.setOnClickListener {
            loadFragment(SecondFragment())
        }

        btn3.setOnClickListener {
            loadFragment(ThirdFragment())
        }
    }

    fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        val fm: androidx.fragment.app.FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.commit()
    }
}