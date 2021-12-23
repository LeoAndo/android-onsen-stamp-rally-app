package com.onsenstamprallyapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenHomeBinding
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.ui.util.viewBindings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnsenHomeFragment : Fragment(R.layout.fragment_onsen_home) {
    private val binding by viewBindings(FragmentOnsenHomeBinding::bind)
    private val viewModel by viewModels<OnsenHomeViewModel>()
    private val logTag by LogTag()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.print()
    }
}