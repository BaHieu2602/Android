package com.example.csesport

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiti_main)
        //val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_nav)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val frameMain = findViewById<FrameLayout>(R.id.frame_main)
            //2.xu ly su kien khi chon item tren navbottom
        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_item_running -> {
                    loadFragment(RunningFragment())
                    true

                }

            R.id.menu_item_cycling ->{
                loadFragment(CyclingFragment())
                 true
            }
        }
        true

    }


        }
    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main, fragment)
            .commit()
        }
}
