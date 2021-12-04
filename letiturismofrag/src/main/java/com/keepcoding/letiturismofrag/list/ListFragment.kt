package com.keepcoding.letiturismofrag.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.keepcoding.letiturismofrag.databinding.FragmentListBinding
import com.keepcoding.letiturismofrag.main.MainActivity
import com.keepcoding.letiturismofrag.model.SitiosTuristicos
import com.keepcoding.letiturismofrag.model.SitiosTuristicosItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private var listSitiosTuristicos: ArrayList<SitiosTuristicosItem>  = arrayListOf()
    private lateinit var sitiosTuristicosAdapter: SitiosTuristicosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
                (activity as MainActivity)?.hideIcon()
            listViewModel.loadMockSitiosTuristicosFromJson(context?.assets?.open("poi.json"))

            listViewModel.onSitiosTuristicosLoaded.observe(viewLifecycleOwner,{result -> onSitiosTuristicosLoadedSubscribe(result)})

            sitiosTuristicosAdapter = SitiosTuristicosAdapter(listSitiosTuristicos, onItemClicked = {onSitiosTuristicosClicked(it) })

            listBinding.poiRecyclerView.apply{
                layoutManager = LinearLayoutManager(context)
                adapter = sitiosTuristicosAdapter
                setHasFixedSize(false)
            }
    }

    private fun onSitiosTuristicosLoadedSubscribe(result: ArrayList<SitiosTuristicosItem>?){
        result?.let{ listSitiosTuristicos ->
            sitiosTuristicosAdapter.appendItems(listSitiosTuristicos)

        }

    }

    private fun onSitiosTuristicosClicked(sitiosTuristicos: SitiosTuristicosItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitioTuristico = sitiosTuristicos))
    }

}