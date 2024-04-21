package com.example.project160420055.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.project160420055.R
import com.example.project160420055.databinding.FragmentRegisBinding
import com.example.project160420055.viewmodel.RegisViewModel

class RegisFragment : Fragment() {
        private lateinit var binding: FragmentRegisBinding
        private lateinit var regisModel : RegisViewModel

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentRegisBinding.inflate(inflater, container, false)
            return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegsitrasi.setOnClickListener{
            val username = binding.txtUsername.text
            val password = binding.txtPassword.text
            val email = binding.txtEmail.text
            val fname = binding.txtFName.text
            val mname = binding.txtMName.text
            val lname = binding.txtLName.text

            //regisModel = ViewModelProvider(this).get(RegisViewModel::class.java)
        }

    }

}