package com.graffiti75.shoestore.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graffiti75.shoestore.R
import com.graffiti75.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        binding.fab.setOnClickListener {
//            findNavController().navigate(ShoeListFragmentDirections.actionWelcomeFragmentToInstructionFragment())
            Toast.makeText(requireActivity(), "---", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }
}