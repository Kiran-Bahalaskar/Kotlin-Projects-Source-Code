package com.adt.alphadev.firstprojectinkotlin.Bottom_Navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.adt.alphadev.firstprojectinkotlin.Bottom_Navigation.Fragments.Fragment_First
import com.adt.alphadev.firstprojectinkotlin.Bottom_Navigation.Fragments.Fragment_Second
import com.adt.alphadev.firstprojectinkotlin.Bottom_Navigation.Fragments.Fragment_Third
import com.adt.alphadev.firstprojectinkotlin.R
import kotlinx.android.synthetic.main.activity_bottom__navigation.*

class ActivityBottom_Navigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom__navigation)

        val firstFragment = Fragment_First()
        val secondFragment = Fragment_Second()
        val thirdFragment = Fragment_Third()

        setCurrentFragment(firstFragment)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_home->setCurrentFragment(firstFragment)
                R.id.nav_person->setCurrentFragment(secondFragment)
                R.id.nav_settings->setCurrentFragment(thirdFragment)
            }

            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fm_fragment, fragment)
            commit()
        }
}