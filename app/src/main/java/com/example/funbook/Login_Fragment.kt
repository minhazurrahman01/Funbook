package com.example.funbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.navigation.fragment.findNavController
import com.example.funbook.databinding.FragmentLoginBinding

class Login_Fragment : Fragment() {

lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentLoginBinding.inflate(inflater,container,false)
        binding.dontHaveAccountTv.setOnClickListener {
            findNavController().navigate(R.id.action_login_Fragment_to_registration_Fragment)
        }
        return binding.root
    }

}