package com.example.mycode.View

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mycode.View.Etisalat.HomeEtisalatFragment
import com.example.mycode.View.Orane.HomeOrangeFragment
import com.example.mycode.View.Vodafone.HomeVodafoneFragment
import com.example.mycode.View.We.HomeWeFragment

class MyAdapterViewPager(fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity){
    var arrFarg = arrayOf(HomeVodafoneFragment() , HomeOrangeFragment(), HomeWeFragment() ,HomeEtisalatFragment())

    override fun getItemCount(): Int {
        return arrFarg.size
    }

    override fun createFragment(position: Int): Fragment {
    return arrFarg[position]
     }
}