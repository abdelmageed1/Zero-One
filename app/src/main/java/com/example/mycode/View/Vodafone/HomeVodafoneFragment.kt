package com.example.mycode.View.Vodafone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycode.View.MainActivity
import com.example.mycode.databinding.FragmentVodafoneBinding


class HomeVodafoneFragment : Fragment() {
    lateinit var binding: FragmentVodafoneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentVodafoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vodafoneCash.setOnClickListener {
            goToVodafoneCash()


        }

        binding.vodafoneService.setOnClickListener {
            goToVodafoneService()
        }


    }

    private fun goToVodafoneService() {
        var act = activity as MainActivity
        act.goToVodafoneService()
    }


    private fun goToVodafoneCash() {

        var act = activity as MainActivity
        act.goToVCash()



    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            HomeVodafoneFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
