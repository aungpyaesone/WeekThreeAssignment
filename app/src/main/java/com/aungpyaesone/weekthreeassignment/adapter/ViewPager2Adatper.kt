package com.aungpyaesone.weekthreeassignment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aungpyaesone.weekthreeassignment.fragment.NearByFragment

class ViewPager2Adatper(fragment:FragmentActivity): FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when {
            position == 0 -> return NearByFragment.newInstance("a","b")
            position == 1 -> return NearByFragment.newInstance("a","b")
            else -> return NearByFragment.newInstance("c","d")
        }
    }

}