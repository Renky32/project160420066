package com.example.project160420055.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.project160420055.R
import com.example.project160420055.databinding.FragmentDetailBinding
import com.example.project160420055.model.Hobby
import com.example.project160420055.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    private lateinit var viewmodel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding
    val listDetail = ArrayList<Hobby>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailId = arguments?.getInt("id")?:0

    }
}