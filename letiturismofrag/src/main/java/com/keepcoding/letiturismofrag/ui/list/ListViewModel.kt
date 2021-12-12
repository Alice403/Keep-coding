package com.keepcoding.letiturismofrag.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.keepcoding.letiturismofrag.data.SitiosturisticosRepository
import com.keepcoding.letiturismofrag.model.SitiosTuristicos
import com.keepcoding.letiturismofrag.model.SitiosTuristicosItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel: ViewModel() {

    private var sitiosTuristicosLoad: MutableLiveData<ArrayList<SitiosTuristicosItem>> = MutableLiveData()
    val onSitiosTuristicosLoaded: LiveData<ArrayList<SitiosTuristicosItem>> = sitiosTuristicosLoad

    private val repository = SitiosturisticosRepository()

    fun getSitiosturisticosFromServer(){
        GlobalScope.launch(Dispatchers.IO){
        sitiosTuristicosLoad.postValue(repository.getSitiosturisticos())
        }
    }

    fun loadMockSitiosTuristicosFromJson(sitiosTuristicosString: InputStream?){
        val sitioTuristicoString = sitiosTuristicosString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitiosTuristicosLoad.value = gson.fromJson(sitioTuristicoString, SitiosTuristicos::class.java)
    }


}