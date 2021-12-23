package com.onsenstamprallyapp.ui.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenListBinding
import com.onsenstamprallyapp.model.OnsenInfo
import com.onsenstamprallyapp.ui.util.AutoCompleteTextViewExt
import com.onsenstamprallyapp.ui.util.viewBindings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnsenListFragment : Fragment(R.layout.fragment_onsen_list), AutoCompleteTextViewExt {
    private val binding by viewBindings(FragmentOnsenListBinding::bind)
    private val viewModel by viewModels<OnsenListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        viewModel.print()

        val testData = listOf(
            OnsenInfo(title = "富士の湯", subTitle = "bbb"),
            OnsenInfo(title = "湯どんぶり栄湯", subTitle = "bbb"),
            OnsenInfo(title = "堤柳泉", subTitle = "bbb"),
            OnsenInfo(title = "鶴の湯", subTitle = "bbb"),
            OnsenInfo(title = "アクアプレイス旭", subTitle = "bbb"),
            OnsenInfo(title = "曙湯", subTitle = "bbb"),
            OnsenInfo(title = "日の出湯", subTitle = "bbb"),
            OnsenInfo(title = "三筋湯", subTitle = "bbb"),
            OnsenInfo(title = "帝国湯", subTitle = "bbb"),
            OnsenInfo(title = "鶴の湯", subTitle = "bbb"),
            OnsenInfo(title = "弁天湯", subTitle = "bbb"),
        )

        val onsenListAdapter = OnsenListAdapter {
            Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
        }
        onsenListAdapter.submitList(testData)
        binding.onsenList.apply {
            adapter = onsenListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.filterBox.setupSearchFilters()
    }
}