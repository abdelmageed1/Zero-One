package com.example.mycode.View.Vodafone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycode.databinding.FragmentVodafoneServiceBinding


class VodafoneServiceFragment : Fragment() {
    lateinit var binding: FragmentVodafoneServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVodafoneServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKnowNumber.setOnClickListener {
            callWithCode("*878#")
        }

        binding.btnBalanceQuiry.setOnClickListener {
            callWithCode("*60#")
        }

        binding.btnInternetPackage.setOnClickListener {
            callWithCode("*2000#")
        }


        binding.btnCallPackage.setOnClickListener {
            callWithCode("*880#")
        }


        binding.btnCallPackageRenewal.setOnClickListener {
            callWithCode("*225#")
        }



        binding.btnKnowledgeConsumption.setOnClickListener {
            callWithCode("*60#")
        }





    }


    fun callWithCode(code: String) {
        var i = Intent(Intent.ACTION_CALL)
        i.data = Uri.fromParts("tel", code, null)
        startActivity(i)
    }

    companion object {

    private  var instance: VodafoneServiceFragment? = null
        fun getInstance ():VodafoneServiceFragment{
            if (instance == null)
            {
                instance = VodafoneServiceFragment()
            }
            return instance!!
        }


    }
}