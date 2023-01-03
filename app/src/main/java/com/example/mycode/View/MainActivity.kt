package com.example.mycode.View

import android.Manifest

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import com.example.mycode.R
import com.example.mycode.util.NumberAndAmountFragment
import com.example.mycode.View.Vodafone.VCashServiceFragment
import com.example.mycode.View.Vodafone.VodafoneServiceFragment
import com.example.mycode.databinding.ActivityMainBinding
import com.example.mycode.util.AmountFragment
import com.google.android.material.tabs.TabLayoutMediator

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        setPermission()
         setAdapter()



    }

    private fun setPermission() {
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED
              )
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE) ,101)
        }
    }

    private fun setAdapter() {
         var adapter= MyAdapterViewPager(this)
        binding.viewPager2.adapter = adapter
        val title = arrayOf("فودافون" ,"اورانج","وي" ,"اتصالات")
        TabLayoutMediator(binding.tabLayout , binding.viewPager2){ tab , position ->
            tab.text = title[position]
        }.attach()
    }

    fun goToVCash() {
        supportFragmentManager.beginTransaction().replace(R.id.homeVodafone , VCashServiceFragment.getInstance())
            .addToBackStack("").commit()
    }

    fun goToNumAndAmount() {
        supportFragmentManager.beginTransaction().replace(R.id.homeVodafone , NumberAndAmountFragment.getInstance())
            .addToBackStack("").commit()
    }

    fun goToAmountFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.homeVodafone , AmountFragment.getInstance())
            .addToBackStack("").commit()
    }

    fun goToVodafoneService() {
        supportFragmentManager.beginTransaction().replace(R.id.homeVodafone , VodafoneServiceFragment.getInstance())
            .addToBackStack("").commit()
    }
}