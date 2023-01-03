package com.example.mycode.util

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mycode.R
import com.example.mycode.databinding.FragmentAmountBinding


class AmountFragment : Fragment() {
lateinit var binding :FragmentAmountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNameOperation.text = strTitleOperation


        binding.btnOkLayout.setOnClickListener {
            onClickOk()
        }

    }





    private fun onClickOk() {

        var amount = binding.etAmountLayout.text.toString()

        if (( amount.isNotEmpty() ))
        {
            var i = Intent(Intent.ACTION_CALL)
            i.data = Uri.fromParts("tel", "$codeStart$amount#", null)
            startActivity(i)

        }
        else{
            Toast.makeText(context, "ادخل قيمة صحيحة", Toast.LENGTH_SHORT)
                .show()
        }
    }

    companion object {

        private var instance: AmountFragment? = null
        lateinit var strTitleOperation : String
        lateinit var codeStart : String


        fun getInstance(): AmountFragment {
            if ( instance == null) {
               instance = AmountFragment()
            }
            return instance!!
        }
            }
    }
