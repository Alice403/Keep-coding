package com.keepcoding.letiturismofrag.data

import com.keepcoding.letiturismofrag.model.SitiosTuristicos
import retrofit2.http.GET

interface ApiService {
    @GET("Alice403/Keep-coding/sitiosturisticos")
    suspend fun getSitiosturisticos(): SitiosTuristicos
}