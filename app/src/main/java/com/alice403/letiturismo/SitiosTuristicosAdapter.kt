package com.alice403.letiturismo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SitiosTuristicosAdapter(
    private val SitiosTuristicosList: ArrayList<SitiosTuristicosItem>
) : RecyclerView.Adapter<SitiosTuristicosAdapter.ViewHolder>() {

    /*Definicion del Layout donde se va a crear la vista*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_poi, parent, false)
        return ViewHolder(view)
    }
    /*Numero de datos de la lista*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitiosTuristicos = SitiosTuristicosList[position]
        holder.bind(sitiosTuristicos)
    }

    /*Tamaño de la lista o Item*/
    override fun getItemCount(): Int = SitiosTuristicosList.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tituloTextView: TextView = itemView.findViewById(R.id.titulo_text_view)
        private var puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.descripcion_text_view)
        private var fotoImageView: ImageView = itemView.findViewById(R.id.foto_image_view)

        fun bind(sitiosTuristicos: SitiosTuristicosItem) {
            tituloTextView.text = sitiosTuristicos.nombre
            puntuacionTextView.text = sitiosTuristicos.puntuacion.toString()
            descriptionTextView.text = sitiosTuristicos.descripcionCorta
            Picasso.get().load(sitiosTuristicos.urlImagen).into(fotoImageView);

        }
    }
}
