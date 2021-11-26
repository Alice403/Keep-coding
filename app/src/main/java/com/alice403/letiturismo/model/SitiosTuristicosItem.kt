package com.alice403.letiturismo.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitiosTuristicosItem(
    @SerializedName("datosAdicionales")
    val datosAdicionales: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("descripcionCorta")
    val descripcionCorta: String,
    @SerializedName("horario")
    val horario: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("precio")
    val precio: String,
    @SerializedName("puntuacion")
    val puntuacion: Double,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("UrlImagen")
    val urlImagen: String
) : Serializable