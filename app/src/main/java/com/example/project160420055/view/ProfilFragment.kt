package com.example.project160420055.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project160420055.R
import com.example.project160420055.databinding.FragmentDetailBinding
import com.example.project160420055.databinding.FragmentProfilBinding
import com.example.project160420055.viewmodel.DetailViewModel
import com.example.project160420055.viewmodel.LoginViewModel

class ProfilFragment : Fragment() {
    private lateinit var viewmodel: LoginViewModel
    private lateinit var binding: FragmentProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}