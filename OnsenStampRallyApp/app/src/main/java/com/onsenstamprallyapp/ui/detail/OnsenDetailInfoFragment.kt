package com.onsenstamprallyapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenDetailBinding
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.ui.home.OnsenHomeViewModel
import com.onsenstamprallyapp.ui.util.viewBindings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class OnsenDetailInfoFragment : Fragment(R.layout.fragment_onsen_detail) {
    private val binding by viewBindings(FragmentOnsenDetailBinding::bind)
    private val viewModel by viewModels<OnsenHomeViewModel>()
    private val logTag by LogTag()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.print()
    }
}