package com.keepcoding.letiturismofrag.data

class SitiosturisticosRepository {

    suspend fun getSitiosturisticos()=WebService.retrofit.getSitiosturisticos()

}