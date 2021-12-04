package com.keepcoding.letiturismofrag.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.keepcoding.letiturismofrag.model.SitiosTuristicos
import com.keepcoding.letiturismofrag.model.SitiosTuristicosItem
import java.io.InputStream

class ListViewModel: ViewModel() {

    private var sitiosTuristicosLoad: MutableLiveData<ArrayList<SitiosTuristicosItem>> = MutableLiveData()
    val onSitiosTuristicosLoaded: LiveData<ArrayList<SitiosTuristicosItem>> = sitiosTuristicosLoad


    fun loadMockSitiosTuristicosFromJson(sitiosTuristicosString: InputStream?){
        val sitioTuristicoString = sitiosTuristicosString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitiosTuristicosLoad.value = gson.fromJson(sitioTuristicoString, SitiosTuristicos::class.java)
    }


}