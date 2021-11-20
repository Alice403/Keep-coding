package com.alice403.letiturismo


import com.google.gson.annotations.SerializedName

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
    val puntuacion: Float,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("UrlImagen")
    val urlImagen: String
)