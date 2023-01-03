package com.example.mycode.View.Vodafone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycode.View.MainActivity
import com.example.mycode.databinding.FragmentVCashServiceBinding
import com.example.mycode.util.AmountFragment
import com.example.mycode.util.NumberAndAmountFragment


class VCashServiceFragment : Fragment() {

    lateinit var binding: FragmentVCashServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVCashServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etVodafoneKnowBalance.setOnClickListener {
            callWithCode("*9*13#")
        }

        binding.etVodafoneMoneyTransfer.setOnClickListener {
            NumberAndAmountFragment.strTitleOperation = "تحويل فلوس"
            NumberAndAmountFragment.codeStart = "*9*7*"
            var act = activity as MainActivity
            act.goToNumAndAmount()

        }

        binding.etVodafoneRechargeToOther.setOnClickListener {
            NumberAndAmountFragment.strTitleOperation = "شحن للغير "
            NumberAndAmountFragment.codeStart = "*9*3*"
            var act = activity as MainActivity
            act.goToNumAndAmount()
        }


        binding.etVodafoneRechargeToMyself.setOnClickListener {
            AmountFragment.strTitleOperation = "شحن لنفسى "
            AmountFragment.codeStart = "*9*0*"
            var act = activity as MainActivity
            act.goToAmountFragment()

        }

    }

    fun callWithCode(code: String) {
        var i = Intent(Intent.ACTION_CALL)
        i.data = Uri.fromParts("tel", code, null)
        startActivity(i)
    }


    companion object {


        private  var instance: VCashServiceFragment? = null
        fun getInstance ():VCashServiceFragment{
            if (instance == null)
            {
                instance = VCashServiceFragment()
            }
            return instance!!
        }
    }
}