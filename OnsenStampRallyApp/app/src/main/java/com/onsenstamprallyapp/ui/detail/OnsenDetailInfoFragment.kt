package com.onsenstamprallyapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.databinding.FragmentOnsenDetailBinding
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.model.OnsenInfoDetail
import com.onsenstamprallyapp.ui.util.AppLaunchHelper
import com.onsenstamprallyapp.ui.util.showErrorDialog
import com.onsenstamprallyapp.ui.util.viewBindings
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
internal class OnsenDetailInfoFragment : Fragment(R.layout.fragment_onsen_detail) {
    private val binding by viewBindings(FragmentOnsenDetailBinding::bind)
    private val logTag by LogTag()
    private val navArgs by navArgs<OnsenDetailInfoFragmentArgs>()
    private val viewModel by viewModels<OnsenDetailInfoViewModel>()

    @Inject
    lateinit var appLaunchHelper: AppLaunchHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.getOnsenInfo(navArgs.onsenInfo.id)
        observeLivedata()
    }

    private fun observeLivedata() {
        viewModel.uistate.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> {
                    showErrorDialog(it.errorMessage, onPositiveButtonClicked = {

                    })
                }
                is UiState.Success -> {
                    updateUi(it.onsenInfo)
                }
            }
        }
    }

    private fun updateUi(onsenInfo: OnsenInfoDetail) {
        binding.apply {
            // set text
            textStoreName.text = onsenInfo.name
            textAddress.text = onsenInfo.address
            textTrafficAccess.text = onsenInfo.trafficAccess
            textTel.text = onsenInfo.tel
            textMailAddress.text = onsenInfo.mailAddress
            textInstagramUrl.text = onsenInfo.instagramUrl
            textTwitterUrl.text = onsenInfo.twitterUrl
            textFacebookUrl.text = onsenInfo.facebookUrl
            textHomepageUrl.text = onsenInfo.homepageUrl
            textRegularHoliday.text = onsenInfo.regularHoliday
            textBusinessHours.text = onsenInfo.businessHours
            textExplanationOfSaunaFee.text = onsenInfo.explanationOfSaunaFee
            textRunningStationSupport.text =
                if (onsenInfo.isRunningStation) {
                    getString(R.string.be)
                } else {
                    getString(R.string.none)
                }
            textFreeWifiSupport.text = if (onsenInfo.isFreeWifi) {
                getString(R.string.be)
            } else {
                getString(R.string.none)
            }
            textStamped.text = if (onsenInfo.isStamped) {
                getString(R.string.be)
            } else {
                getString(R.string.none)
            }

            // listener
            textAddress.setOnClickListener {
                appLaunchHelper.launchMapApp(
                    onsenInfo.latitude,
                    onsenInfo.longitude,
                    onsenInfo.address
                )
            }
            textTel.setOnClickListener {
                appLaunchHelper.launchTelApp(onsenInfo.tel)
            }
            textMailAddress.setOnClickListener {
                appLaunchHelper.launchMailApp(
                    address = onsenInfo.mailAddress,
                    subject = "",
                    text = ""
                )
            }
            textInstagramUrl.setOnClickListener {
                appLaunchHelper.launchInstagramApp(onsenInfo.instagramUrl)
            }
            textTwitterUrl.setOnClickListener {
                appLaunchHelper.launchTwitterApp(onsenInfo.twitterUrl)
            }
            textFacebookUrl.setOnClickListener {
                appLaunchHelper.launchFacebookApp(onsenInfo.facebookUrl)
            }
            textHomepageUrl.setOnClickListener {
                appLaunchHelper.launchBrowserApp(onsenInfo.homepageUrl)
            }
        }
    }
}