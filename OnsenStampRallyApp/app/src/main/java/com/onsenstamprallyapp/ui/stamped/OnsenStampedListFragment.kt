package com.onsenstamprallyapp.ui.stamped

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenStampedListBinding

class OnsenStampedListFragment : Fragment(R.layout.fragment_onsen_stamped_list) {
    private var _binding: FragmentOnsenStampedListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnsenStampedListBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}