package com.example.funbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.funbook.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Fragment :  BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


     var userr=  FirebaseAuth.getInstance().currentUser


       if (userr!=null) {
        findNavController().navigate(R.id.action_login_Fragment_to_homeFragment)
    }


        binding.dontHaveAccountTv.setOnClickListener {
            findNavController().navigate(R.id.action_login_Fragment_to_registration_Fragment)
        }


        binding.loginBtn.setOnClickListener {
            val email= binding.emailTextField.text.toString().trim()
            val password= binding.passwordTextField.text.toString().trim()

            login(email,password)
        }


    }

    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
            findNavController().navigate(R.id.action_login_Fragment_to_homeFragment)

        }.addOnFailureListener {
            val alertDialog= AlertDialog.Builder(requireActivity()).setTitle("Error")
                .setMessage(it.message)
            alertDialog.create().show()
        }

    }

}