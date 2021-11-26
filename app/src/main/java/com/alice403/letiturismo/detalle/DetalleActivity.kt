package com.alice403.letiturismo.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alice403.letiturismo.R
import com.alice403.letiturismo.databinding.ActivityDetalleBinding
import com.alice403.letiturismo.model.SitiosTuristicosItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)

        setContentView(detalleBinding.root)
        //val titulo = intent.extras?.getString( "titulo" )
        val sitioTuristico: SitiosTuristicosItem = intent.extras?.getSerializable( "sitioTuristico" ) as SitiosTuristicosItem
        with(detalleBinding){
            tituloTextView.text = sitioTuristico.nombre
            descripTextView.text = sitioTuristico.descripcion
            datAdTextView.text = sitioTuristico.datosAdicionales
            temperaturaTextView.text = sitioTuristico.temperatura
            ubicacionTextView.text = sitioTuristico.ubicacion
            horarioTextView.text = sitioTuristico.horario
            Picasso.get().load(sitioTuristico.urlImagen).into(imageView1)
        }




    }
}