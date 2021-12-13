package com.keepcoding.letiturismofrag.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import com.keepcoding.letiturismofrag.R
import com.keepcoding.letiturismofrag.databinding.FragmentSplashBinding
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timerTask

class SplashFragment : Fragment() {

    private lateinit var splashBinding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_splash, container, false)
        //splashBinding = FragmentSplashBinding.inflate(inflater, container, false)
        //return splashBinding.root
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_listFragment)
        },5000)
        return view
    }
}

/*

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread.sleep(3000)
        goToListFragment()
    }
    private fun goToListFragment() {
        findNavController().navigate(R.id.action_splashFragment_to_listFragment,
            null,
            NavOptions.Builder()
                .setPopUpTo(R.id.splashFragment,
                    true).build())
        //findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToListFragment())
    }

}
*/
