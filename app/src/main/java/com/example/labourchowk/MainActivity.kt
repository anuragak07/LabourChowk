package com.example.labourchowk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        material.setNavigationOnClickListener {
            draw.openDrawer(GravityCompat.START)
        }

        fragmentManager=supportFragmentManager
        loadFragment(HomeFragment())


        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Home -> {

                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
               /* R.id.Profile -> {

                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }*/
                R.id.list -> {

                   loadFragment(LabourFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener true

        }


    }
    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framecontainer, fragment)
        transaction.addToBackStack("addFrag")
        transaction.commit()
    }
}