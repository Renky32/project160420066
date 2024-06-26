package com.example.project160420055.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.project160420055.R
import com.example.project160420055.databinding.FragmentDetailBinding
import com.example.project160420055.model.Hobby
import com.example.project160420055.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private lateinit var viewmodel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding
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
        viewmodel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewmodel.fetch(detailId)


        viewmodel.detailLD.observe(viewLifecycleOwner, Observer {
            binding.txtJudul.setText(it.judul)
            binding.txtIsi.setText(it.detail)
            binding.txtUser.setText(it.username)
            Picasso.get().load(it.urlGambar).into(binding.imgUser)
        })

    }
}