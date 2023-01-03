package com.example.mycode.View.Orane

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycode.databinding.FragmentOrangeBinding


class HomeOrangeFragment : Fragment() {
    lateinit var binding: FragmentOrangeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOrangeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKnowNumber.setOnClickListener {
            callWithCode("#119#")
        }

        binding.btnBalanceQuiry.setOnClickListener {
            callWithCode("#100#111#")
        }

        binding.btnInternetPackage.setOnClickListener {
            callWithCode("#100#4#")
        }


        binding.btnCallPackage.setOnClickListener {
            callWithCode("#0#")
        }


        binding.btnCallPackageRenewal.setOnClickListener {
            callWithCode("#0#")
        }



        binding.btnKnowledgeConsumption.setOnClickListener {
            callWithCode("#0#")
        }





    }


    fun callWithCode(code: String) {
        var i = Intent(Intent.ACTION_CALL)
        i.data = Uri.fromParts("tel", code, null)
        startActivity(i)
    }


    companion object {


        fun newInstance(param1: String, param2: String) =
            HomeOrangeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}