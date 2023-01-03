package com.example.mycode.View.We

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycode.databinding.FragmentWeBinding

class HomeWeFragment : Fragment() {
    lateinit var binding: FragmentWeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentWeBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeWeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}