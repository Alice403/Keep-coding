package com.keepcoding.letiturismofrag.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.keepcoding.letiturismofrag.databinding.FragmentDetailBinding
import com.keepcoding.letiturismofrag.ui.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val sitioTuristico = args.sitioTuristico

        with(detailBinding){
            tituloTextView.text = sitioTuristico.nombre
            descripTextView.text = sitioTuristico.descripcion
            datAdTextView.text = sitioTuristico.datosAdicionales
            temperaturaTextView.text = sitioTuristico.temperatura
            ubicacionTextView.text = sitioTuristico.ubicacion
            horarioTextView.text = sitioTuristico.horario
            ratingBarHappy.rating = sitioTuristico.puntuacionrating.toFloat()
            Picasso.get().load(sitioTuristico.urlImagen1).into(imageView1)
            Picasso.get().load(sitioTuristico.urlImagen2).into(imageView2)
            Picasso.get().load(sitioTuristico.urlImagen3).into(imageView3)

            mapButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(sitioTuristico = sitioTuristico))
            }
         }
    }
}