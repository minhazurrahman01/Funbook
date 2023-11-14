package com.example.funbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.funbook.databinding.FragmentRegistrationBinding

class Registration_Fragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentRegistrationBinding.inflate(inflater,container,false)
        binding.alreadyHaveAccountTv.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root










    }


}