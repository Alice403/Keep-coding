package com.keepcoding.letiturismofrag.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap.*
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.keepcoding.letiturismofrag.R
import com.keepcoding.letiturismofrag.detail.DetailFragmentArgs

class MapsFragment : Fragment() {
    private val args: MapsFragmentArgs by navArgs()
    private val callback = OnMapReadyCallback { googleMap ->
        val sitioTuristico = args.sitioTuristico
        val sitio = LatLng(sitioTuristico.latitud, sitioTuristico.longitud)
        googleMap.addMarker(MarkerOptions().position(sitio).title(sitioTuristico.nombre))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sitio,15F))
        //Cambio de Estilo de Mapa
        googleMap.setMapType(MAP_TYPE_HYBRID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}