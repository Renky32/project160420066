package com.example.project160420055.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project160420055.R
import com.example.project160420055.databinding.FragmentHobbyNewsBinding
import com.example.project160420055.viewmodel.ListViewModel

class HobbyNewsFragment : Fragment() {
    private lateinit var hobModel : ListViewModel
    private lateinit var binding : FragmentHobbyNewsBinding
    private val hobbyNewsAdapter = HobbyNewsAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentHobbyNewsBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hobModel = ViewModelProvider(this).get(ListViewModel:: class.java)
        hobModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter =hobbyNewsAdapter

        observeViewModel()

        binding.refreshLayout.setOnRefreshListener {
            binding.recView.visibility = View.GONE
            binding.txtError.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            hobModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }
        binding.btnProfil.setOnClickListener{
            val action = HobbyNewsFragmentDirections.actionProfilFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun observeViewModel(){
        hobModel.newsLD.observe(viewLifecycleOwner, Observer {
            hobbyNewsAdapter.updateNewsList(it)
        })
        hobModel.newsLoadErrorLD.observe(viewLifecycleOwner, Observer{
            if(it == true) {
                binding.txtError?.visibility = View.VISIBLE
            } else {
                binding.txtError?.visibility = View.GONE
            }
        })
        hobModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })
    }

}