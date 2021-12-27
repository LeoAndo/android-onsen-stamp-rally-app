package com.onsenstamprallyapp.ui.list

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenListBinding
import com.onsenstamprallyapp.ui.util.showErrorDialog
import com.onsenstamprallyapp.ui.util.viewBindings
import com.onsenstamprallyapp.ui.widget.OnsenListAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
internal class OnsenListFragment : Fragment(R.layout.fragment_onsen_list) {
    private lateinit var onsenListAdapter: OnsenListAdapter
    private val binding by viewBindings(FragmentOnsenListBinding::bind)
    private val viewModel by viewModels<OnsenListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLivedata()
        binding.apply {
            setupOnsenList(onsenList)
            setupFilterBox(filterBox)
        }
    }

    private fun observeLivedata() {
        viewModel.uistate.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> {
                    showErrorDialog(
                        it.throwable.localizedMessage ?: "error..",
                        onPositiveButtonClicked = {

                        })
                }
                is UiState.Success -> {
                    onsenListAdapter.submitList(it.onsenList)
                }
            }
        }
    }

    private fun setupOnsenList(onsenList: RecyclerView) {
        onsenListAdapter = OnsenListAdapter(onItemClick = {
            findNavController().navigate(
                OnsenListFragmentDirections.actionOnsenListFragmentToOnsenDetailInfoFragment(
                    it
                )
            )
        }, onCheckedChange = { id, isStamped ->
            viewModel.updateStampStatus(id, isStamped)
        })
        onsenList.apply {
            adapter = onsenListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupFilterBox(filterBox: Spinner) {
        filterBox.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val parentView = parent ?: return
                viewModel.getOnsenList(parentView.selectedItemPosition)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}