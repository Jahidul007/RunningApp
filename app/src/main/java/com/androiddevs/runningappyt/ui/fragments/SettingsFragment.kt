package com.androiddevs.runningappyt.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.androiddevs.runningappyt.R
import com.androiddevs.runningappyt.others.Constants
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_setup.*
import kotlinx.android.synthetic.main.fragment_setup.etName
import kotlinx.android.synthetic.main.fragment_setup.etWeight
import javax.inject.Inject


@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFromSharedPref()

        btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()
            if (success) {
                Snackbar.make(view, "Updated successfully", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(view, "Please fill out all the fields", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    private fun loadFromSharedPref() {
        val name = sharedPreferences.getString(Constants.KEY_NAME, "") ?: ""
        val weight = sharedPreferences.getFloat(Constants.KEY_WIGHT, 80f)

        etName.setText(name)
        etWeight.setText(weight.toString())


    }

    private fun applyChangesToSharedPref(): Boolean {
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()

        if (nameText.isEmpty() || weightText.isEmpty()) {
            return false

        }
        sharedPreferences.edit()
            .putString(Constants.KEY_NAME, nameText)
            .putFloat(Constants.KEY_WIGHT, weightText.toFloat())
            .putBoolean(Constants.KEY_FIRST_TIME_TOGGLE, false)
            .apply()

        val toolbarText = "Let's go, $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText

        return true
    }
}