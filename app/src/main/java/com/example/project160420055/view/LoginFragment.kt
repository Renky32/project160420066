package com.example.project160420055.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.project160420055.databinding.FragmentLoginBinding
import org.json.JSONException
import org.json.JSONObject
import androidx.navigation.fragment.findNavController
import com.example.project160420055.R
import com.example.project160420055.model.User
import com.example.project160420055.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginmodel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSignIn.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()

            loginmodel.login(username, password)
            loginmodel.userLD.observe(viewLifecycleOwner, Observer { User->
                if (!User.isNullOrEmpty()) {

                    //Toast.makeText(requireContext(), "Login Succsess", Toast.LENGTH_SHORT).show()
                    val user = User[0]
                    findNavController().navigate(LoginFragmentDirections.actionHobbyNewsFragment(user.id))
                } else {
                    Toast.makeText(requireContext(), "Login failed, please try again",
                        Toast.LENGTH_SHORT).show()
                }
            })
        }
        binding.btnRegistrasi.setOnClickListener({
            val action = LoginFragmentDirections.actionRegistFragment()
            Navigation.findNavController(it).navigate(action)
        })
    }
}

