package com.adt.alphadev.firstprojectinkotlin.TabLayout.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.adt.alphadev.firstprojectinkotlin.TabLayout.Fragments.Cricket
import com.adt.alphadev.firstprojectinkotlin.TabLayout.Fragments.FootBall
import com.adt.alphadev.firstprojectinkotlin.TabLayout.Fragments.Hockey

internal class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
    ):
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){

            0 -> {
                FootBall()
            }

            1 -> {
                Cricket()
            }

            2 -> {
                Hockey()
            }
            else -> getItem(position)

        }
    }

    override fun getCount(): Int {
        return totalTabs
    }

}