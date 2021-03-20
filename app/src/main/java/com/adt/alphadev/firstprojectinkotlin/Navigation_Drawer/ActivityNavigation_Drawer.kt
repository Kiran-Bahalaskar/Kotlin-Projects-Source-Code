package com.adt.alphadev.firstprojectinkotlin.Navigation_Drawer

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.adt.alphadev.firstprojectinkotlin.Navigation_Drawer.Fragments.*
import com.adt.alphadev.firstprojectinkotlin.R
import kotlinx.android.synthetic.main.activity_navigation__drawer.*
import kotlinx.android.synthetic.main.my_toolbar.*

class ActivityNavigation_Drawer : AppCompatActivity() {

    private lateinit var homeFragment: Fragment_Home
    private lateinit var personFragment: Fragment_Person
    private lateinit var settingsFragment: Fragment_Settings
    private lateinit var contactFragment: Fragment_Contact
    private lateinit var aboutFragment: Fragment_About

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation__drawer)

        my_toolbar.title = "Home"
        setSupportActionBar(my_toolbar)
        my_toolbar.setTitleTextColor(Color.WHITE)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, my_toolbar, 0, 0)
        toggle.syncState()

        homeFragment = Fragment_Home()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.f1Content, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        nv_View.setNavigationItemSelectedListener{ menu ->

            menu.isChecked = false
            drawerLayout.closeDrawers()

            when(menu.itemId){

                R.id.nav_home -> {
                    homeFragment = Fragment_Home()
                    my_toolbar.title = "Home"
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.f1Content, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_person -> {
                    personFragment = Fragment_Person()
                    my_toolbar.title = "Person"
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.f1Content, personFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_settings -> {
                    settingsFragment = Fragment_Settings()
                    my_toolbar.title = "Settings"
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.f1Content, settingsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_dashboard -> {
                    contactFragment = Fragment_Contact()
                    my_toolbar.title = "DashBoard"
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.f1Content, contactFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_forum -> {
                    aboutFragment = Fragment_About()
                    my_toolbar.title = "About"
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.f1Content, contactFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

            }
            true
        }

    }
}