package com.onsenstamprallyapp.ui.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenMapBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OnsenMapFragment : Fragment(R.layout.fragment_onsen_map) {

    private var _binding: FragmentOnsenMapBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<OnsenMapViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnsenMapBinding.bind(view)
        // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        viewModel.print()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}