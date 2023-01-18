package com.graffiti75.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graffiti75.shoestore.R
import com.graffiti75.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        var name = ""
        var company = ""
        var size = -1
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(
                ShoeDetailFragmentDirections
                    .actionShoeDetailFragmentToShoeListFragment(name, company, size.toString().toInt())
            )
        }

        binding.saveButton.setOnClickListener {
            name = binding.shoeNameEditText.text.toString()
            company = binding.shoeCompanyEditText.text.toString()
            size = binding.shoeSizeEditText.text.toString().toInt()
            findNavController().navigate(
                ShoeDetailFragmentDirections
                    .actionShoeDetailFragmentToShoeListFragment(name, company, size)
            )
        }

        return binding.root
    }
}