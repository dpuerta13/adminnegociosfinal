package com.pordo.adminnegocios.ui.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.pordo.adminnegocios.R
import com.pordo.adminnegocios.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel
    private lateinit var menuFragment: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        menuFragment = FragmentMenuBinding.inflate(inflater,container,false)
        return menuFragment.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuFragment.InventoryView.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToInventoryFragment())
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private fun onProductItemClicked() {
        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToInventoryFragment())
    }
}