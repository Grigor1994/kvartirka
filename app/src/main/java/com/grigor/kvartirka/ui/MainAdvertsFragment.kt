package com.grigor.kvartirka.ui

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.grigor.kvartirka.adapter.AdvertsAdapter
import com.grigor.kvartirka.databinding.FragmentMainAdvertsBinding
import com.grigor.kvartirka.util.LocationHelper
import com.grigor.kvartirka.util.LocationHelper.LOCATION_SETTING_REQUEST
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainAdvertsFragment : Fragment() {

    private lateinit var binding: FragmentMainAdvertsBinding
    private val viewModel: AdvertsViewModel by sharedViewModel()
    private lateinit var navController: NavController

    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainAdvertsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        if (LocationHelper.checkPermissions(requireContext())) {
            if (LocationHelper.isLocationEnabled(requireContext())) {
                getLocation()
            } else {
                showEnableLocationSetting()
            }

        } else {
            LocationHelper.requestPermissions(this@MainAdvertsFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        navController = findNavController()
        super.onActivityCreated(savedInstanceState)
        viewModel.flatsLiveData.observe(viewLifecycleOwner, Observer {
            binding.mainAdvertsRecyclerView.adapter =
                AdvertsAdapter(it?.flats?.take(it.flats.size) ?: listOf(), it?.currency) { flat ->
                    navController.navigate(
                        MainAdvertsFragmentDirections.actionMainAdvertsFragmentToAdvertDetailsFragment(
                            flat
                        )
                    )
                }
        })
    }

    private fun showEnableLocationSetting() {
        activity?.let {
            val locationRequest = LocationRequest.create()
            locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

            val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest)

            val task = LocationServices.getSettingsClient(it)
                .checkLocationSettings(builder.build())

            task.addOnSuccessListener { response ->
                response.locationSettingsStates
            }
            task.addOnFailureListener { e ->
                if (e is ResolvableApiException) {
                    try {
                        // Handle result in onActivityResult()
                        e.startResolutionForResult(
                            it,
                            LOCATION_SETTING_REQUEST
                        )
                    } catch (sendEx: IntentSender.SendIntentException) {
                    }
                }
            }
        }
    }

    private fun getLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    viewModel.getFlats(it.longitude, it.latitude)
                }
            }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            LocationHelper.REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation()
                }
            }
        }
    }

}