package com.keepcoding.letiturismofrag.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.keepcoding.letiturismofrag.databinding.FragmentListBinding
import com.keepcoding.letiturismofrag.model.SitiosTuristicos
import com.keepcoding.letiturismofrag.model.SitiosTuristicosItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listSitiosTuristicos: ArrayList<SitiosTuristicosItem>
    private lateinit var sitiosTuristicosAdapter: SitiosTuristicosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listSitiosTuristicos = loadMockSitiosTuristicosAdapterFromJson()
        sitiosTuristicosAdapter = SitiosTuristicosAdapter(listSitiosTuristicos, onItemClicked = { onSitiosTuristicosClicked(it) })

        listBinding.poiRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosTuristicosAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockSitiosTuristicosAdapterFromJson(): ArrayList<SitiosTuristicosItem> {
        val sitiosTuristicosString: String = context?.assets?.open("poi.json")?.bufferedReader().use{ it!!.readText() } //TODO: reparar !!
        val gson = Gson()
        val data = gson.fromJson(sitiosTuristicosString, SitiosTuristicos::class.java)
        return data
    }

    private fun onSitiosTuristicosClicked(sitiosTuristicos: SitiosTuristicosItem) {

        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitioTuristico = sitiosTuristicos))
        //findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment())
    }

}