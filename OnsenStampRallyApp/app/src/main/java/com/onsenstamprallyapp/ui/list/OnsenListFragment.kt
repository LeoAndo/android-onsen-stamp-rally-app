package com.onsenstamprallyapp.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenListBinding
import com.onsenstamprallyapp.ui.util.viewBindings

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OnsenListFragment : Fragment(R.layout.fragment_onsen_list) {

    private val binding by viewBindings(FragmentOnsenListBinding::bind)
    private val viewModel by viewModels<OnsenListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        viewModel.print()
    }
}