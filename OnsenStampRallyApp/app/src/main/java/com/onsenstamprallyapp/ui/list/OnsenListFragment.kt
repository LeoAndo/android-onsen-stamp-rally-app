package com.onsenstamprallyapp.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenListBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OnsenListFragment : Fragment(R.layout.fragment_onsen_list) {

    private var _binding: FragmentOnsenListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnsenListBinding.bind(view)
        // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}