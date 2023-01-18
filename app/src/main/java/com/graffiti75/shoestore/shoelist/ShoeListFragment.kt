package com.graffiti75.shoestore.shoelist

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.graffiti75.shoestore.R
import com.graffiti75.shoestore.Shoe
import com.graffiti75.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private val viewModel : ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        // The usage of an interface lets you inject your own implementation
        val menuHost: MenuHost = requireActivity()
        addMenu(menuHost)
        addShoeToList()

        return binding.root
    }

    private fun addShoeToList() {
        val args = ShoeListFragmentArgs.fromBundle(requireArguments())
        val name = args.name
        val company = args.company
        val size = args.size
        val shoe = Shoe(name, company, size, "")
        Log.i("ShoeListFragment", "addShoeToList() -> Shoe: $shoe")
        if (name.isNotBlank() && company.isNotBlank() && size > 0)
            viewModel.addShoeToList(shoe)
    }

    private fun addMenu(menuHost: MenuHost) {
        // Add menu items without using the Fragment Menu APIs
        // Note how we can tie the MenuProvider to the viewLifecycleOwner
        // and an optional Lifecycle.State (here, RESUMED) to indicate when
        // the menu should be visible
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.winner_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}