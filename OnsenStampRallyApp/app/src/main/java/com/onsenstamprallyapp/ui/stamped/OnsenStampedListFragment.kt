package com.onsenstamprallyapp.ui.stamped

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenStampedListBinding
import com.onsenstamprallyapp.ui.util.viewBindings

class OnsenStampedListFragment : Fragment(R.layout.fragment_onsen_stamped_list) {
    private val binding by viewBindings(FragmentOnsenStampedListBinding::bind)
    private val viewModel by viewModels<OnsenStampedListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.print()
    }
}