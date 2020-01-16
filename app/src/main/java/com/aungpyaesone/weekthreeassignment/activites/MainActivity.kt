package com.aungpyaesone.weekthreeassignment.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.aungpyaesone.weekthreeassignment.R
import com.aungpyaesone.weekthreeassignment.fragment.BookmarkFragment
import com.aungpyaesone.weekthreeassignment.fragment.DateFragment
import com.aungpyaesone.weekthreeassignment.fragment.HomeFrgment
import com.aungpyaesone.weekthreeassignment.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callFragment(HomeFrgment.newInstance("a","b"))

        bottomNav.setOnNavigationItemSelectedListener(object :
        BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.nav_home -> {
                    callFragment(HomeFrgment.newInstance("a","b"))
                    return true
                }
                R.id.nav_search -> {
                    callFragment(SearchFragment.newInstance("b","d"))
                    return true
                }
                R.id.nav_date_range -> {
                    callFragment(DateFragment.newInstance("e","f"))
                    return true
                }
                R.id.nav_bookmark ->{
                    callFragment(BookmarkFragment.newInstance("g","h"))
                    return true
                }
            }
                return false
            }
            })

    }

    fun callFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}
