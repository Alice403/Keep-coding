package com.keepcoding.letiturismofrag.model


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
    val puntuacion: String,
    @SerializedName("puntuacionrating")
    val puntuacionrating: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("UrlImagen")
    val urlImagen: String,
    @SerializedName("UrlImagen1")
    val urlImagen1: String,
    @SerializedName("UrlImagen2")
    val urlImagen2: String,
    @SerializedName("UrlImagen3")
    val urlImagen3: String

) : Serializable