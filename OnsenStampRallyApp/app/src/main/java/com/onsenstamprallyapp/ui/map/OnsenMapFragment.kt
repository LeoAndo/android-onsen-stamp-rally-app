package com.onsenstamprallyapp.ui.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenMapBinding
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper
import com.onsenstamprallyapp.ui.util.viewBindings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnsenMapFragment : Fragment(R.layout.fragment_onsen_map) {

    private lateinit var map: GoogleMap
    private val binding by viewBindings(FragmentOnsenMapBinding::bind)
    private val viewModel by viewModels<OnsenMapViewModel>()
    private val logTag by LogTag()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        viewModel.print()
        binding.mapView.getMapAsync {
            LogWrapper.print(logTag, "map async successFull: ${it.mapType}")
            map = it
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(37.614631, -122.385153), 18f))
        }
    }
}