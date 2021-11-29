package com.keepcoding.letiturismofrag.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.keepcoding.letiturismofrag.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}