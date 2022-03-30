package com.pordo.adminnegocios.ui.sales

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pordo.adminnegocios.R

class SalesFragment : Fragment() {

    companion object {
        fun newInstance() = SalesFragment()
    }

    private lateinit var viewModel: SalesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sales, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SalesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}