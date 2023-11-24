package com.example.funbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.funbook.databinding.FragmentRegistrationBinding
import com.google.firebase.auth.FirebaseAuth



class Registration_Fragment : BaseFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.registerbtn.setOnClickListener {
            val name= binding.rUserTextField.text.toString().trim()
            val email= binding.rEmailTextField.text.toString().trim()
            val password= binding.rPasswordTextField.text.toString().trim()

            registration(name,email,password)

        }

        binding.alreadyHaveAccountTv.setOnClickListener {
            findNavController().popBackStack()
        }


    }

    private fun registration(name: String, email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {


//            mRef.push().key

            val user=Users(
                name=name,
                email = email,
                password = password,
                userid = it.user!!.uid,
                profileImg = ""
            )

            mRef.child("users").child(user.userid).setValue(user).addOnSuccessListener {
                mAuth.signOut()
                findNavController().popBackStack()
            }.addOnFailureListener {
                val alertDialog=AlertDialog.Builder(requireActivity()).setTitle("Error")
                    .setMessage(it.message)
                alertDialog.create().show()
            }



        }.addOnFailureListener {
            val alertDialog=AlertDialog.Builder(requireActivity()).setTitle("Error")
                .setMessage(it.message)
            alertDialog.create().show()
        }

    }


}