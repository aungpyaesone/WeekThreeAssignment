package com.aungpyaesone.weekthreeassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.aungpyaesone.weekthreeassignment.R

class TopSearchAdapter: PagerAdapter() {
    companion object{
        const val COUNT = 4
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
       return COUNT
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(container.context)
        val v = layoutInflater.inflate(R.layout.top_searches_item_view,container,false)
        container.addView(v)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}