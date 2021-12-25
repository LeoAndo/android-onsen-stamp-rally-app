package com.onsenstamprallyapp.ui.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenListBinding
import com.onsenstamprallyapp.ui.util.setupSearchFilters
import com.onsenstamprallyapp.ui.util.showErrorDialog
import com.onsenstamprallyapp.ui.util.viewBindings
import com.onsenstamprallyapp.ui.widget.OnsenListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnsenListFragment : Fragment(R.layout.fragment_onsen_list) {
    private lateinit var onsenListAdapter: OnsenListAdapter
    private val binding by viewBindings(FragmentOnsenListBinding::bind)
    private val viewModel by viewModels<OnsenListViewModel>()
//    private val exceptionHandler =
//        ErrorHandler(fragment = this, onPositiveButtonClicked = {
//        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLivedata()

        onsenListAdapter = OnsenListAdapter {
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
            findNavController().navigate(
                OnsenListFragmentDirections.actionOnsenListFragmentToOnsenDetailInfoFragment(
                    it
                )
            )
        }
        binding.onsenList.apply {
            adapter = onsenListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.filterBox.setupSearchFilters()
        binding.filterBox.setOnItemClickListener { parent, _, position, _ ->
            val selectItemId = parent.getItemIdAtPosition(position).toInt()
            viewModel.getOnsenList(selectItemId)
        }
    }

    private fun observeLivedata() {
        viewModel.uistate.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> {
                    showErrorDialog(it.errorMessage, onPositiveButtonClicked = {

                    })
                }
                is UiState.Success -> {
                    onsenListAdapter.submitList(it.onsenList)
                }
            }
        }
    }
}