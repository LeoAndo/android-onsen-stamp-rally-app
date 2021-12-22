package com.onsenstamprallyapp.ui.stamped

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenStampedListBinding

class OnsenStampedListFragment : Fragment(R.layout.fragment_onsen_stamped_list) {
    private var _binding: FragmentOnsenStampedListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<OnsenStampedListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnsenStampedListBinding.bind(view)
        viewModel.print()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}