package com.onsenstamprallyapp.ui.goods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.data.GoodsData
import com.onsenstamprallyapp.databinding.FragmentOnsenGoodsListBinding
import com.onsenstamprallyapp.ui.util.viewBindings
import com.onsenstamprallyapp.ui.widget.GoodsListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoodsListFragment : Fragment(R.layout.fragment_onsen_goods_list) {
    private lateinit var onsenListAdapter: GoodsListAdapter
    private val binding by viewBindings(FragmentOnsenGoodsListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onsenListAdapter = GoodsListAdapter()
        binding.onsenList.apply {
            adapter = onsenListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        onsenListAdapter.submitList(GoodsData.dataList)
    }
}