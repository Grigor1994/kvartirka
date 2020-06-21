package com.grigor.kvartirka.ui

import android.content.Intent
import android.content.IntentSender
import android.location.Location
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.grigor.kvartirka.adapter.AdvertsAdapter
import com.grigor.kvartirka.data.Advert
import com.grigor.kvartirka.databinding.FragmentMainAdvertsBinding
import com.grigor.kvartirka.util.LocationHelper
import kotlinx.android.synthetic.main.fragment_main_adverts.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainAdvertsFragment : Fragment() {

    private lateinit var binding: FragmentMainAdvertsBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    private lateinit var mLastLocation: Location

    private val viewModel: MainAdvertsViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainAdvertsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        if (LocationHelper.checkPermissions(requireContext())) {
            if (LocationHelper.isLocationEnabled(requireContext()))
                buildLocationCallback()

            else {
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }

        } else {
            LocationHelper.requestPermissions(this@MainAdvertsFragment)
        }

        createLocationRequest()
        showEnableLocationSetting()
        val adverts = arrayListOf<Advert>()

        for (i in 0..100) {
            adverts.add(
                Advert(
                    2,
                    "Плошадь Республики",
                    "Амирян $i",
                    "Кондиционер, Wi-Fi, без вечеринок, не курить, cтир. машина, утюг, ТВ",
                    2500,
                    "https://media.kvartirka.com/thumbs/flat/0/252/252470/1985266_w936h624.jpg"
                )
            )
        }
        recycler_view.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = AdvertsAdapter(adverts)
        }
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest().apply {
            interval = 10000
            fastestInterval = 5000
            numUpdates = 1
        }
        Log.i("HomeFragment", "Location Request")
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
        Log.i("HomeFragment", "Method Called")
    }

    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult?) {
                mLastLocation = p0!!.locations[p0.locations.size - 1]
                viewModel.getFlats(mLastLocation.longitude, mLastLocation.latitude)
            }
        }
    }

    companion object {
        const val LOCATION_SETTING_REQUEST = 999
    }
}