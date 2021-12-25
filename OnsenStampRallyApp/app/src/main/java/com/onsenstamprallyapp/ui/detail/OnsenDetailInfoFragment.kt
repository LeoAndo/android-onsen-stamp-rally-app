package com.onsenstamprallyapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenDetailBinding
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.ui.util.viewBindings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class OnsenDetailInfoFragment : Fragment(R.layout.fragment_onsen_detail) {
    private val binding by viewBindings(FragmentOnsenDetailBinding::bind)
    private val logTag by LogTag()
    private val navArgs by navArgs<OnsenDetailInfoFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = navArgs.onsenInfo.name
    }
}