package com.onsenstamprallyapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.data.GoodsData
import com.onsenstamprallyapp.databinding.FragmentOnsenHomeBinding
import com.onsenstamprallyapp.ui.util.showErrorDialog
import com.onsenstamprallyapp.ui.util.viewBindings
import com.onsenstamprallyapp.ui.widget.GoodsListAdapter
import com.onsenstamprallyapp.ui.widget.OnsenListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class OnsenHomeFragment : Fragment(R.layout.fragment_onsen_home) {
    private lateinit var listAdapter: OnsenListAdapter
    private lateinit var goodsListAdapter: GoodsListAdapter
    private val binding by viewBindings(FragmentOnsenHomeBinding::bind)
    private val viewModel by viewModels<OnsenHomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLivedata()
        setupListAdapter()
        setupSeeMoreListener()
    }

    private fun setupSeeMoreListener() {
        binding.textSeeMore.setOnClickListener {
            findNavController().navigate(
                OnsenHomeFragmentDirections.actionOnsenHomeFragmentToOnsenListFragment()
            )
        }
        binding.textSeeMoreGoods.setOnClickListener {
            findNavController().navigate(
                OnsenHomeFragmentDirections.actionOnsenHomeFragmentToGoodsListFragment()
            )
        }
    }

    private fun setupListAdapter() {
        listAdapter = OnsenListAdapter(onItemClick = {
            findNavController().navigate(
                OnsenHomeFragmentDirections.actionOnsenHomeFragmentToOnsenDetailInfoFragment(
                    it
                )
            )
        }, onCheckedChange = { id, isStamped ->
            viewModel.updateStampStatus(id, isStamped)
        })
        binding.onsenList.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(false)
        }

        goodsListAdapter = GoodsListAdapter()
        binding.goodsList.apply {
            adapter = goodsListAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(false)
        }
        goodsListAdapter.submitList(GoodsData.dataList.take(3))
    }

    private fun observeLivedata() {
        viewModel.uistate.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> {
                    showErrorDialog(it.errorMessage, onPositiveButtonClicked = {

                    })
                }
                is UiState.Success -> {
                    listAdapter.submitList(it.onsenList)
                }
            }
        }
    }
}