package com.example.githubexplorer.presentation.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.setFragment(containerId: Int, fragment: Fragment) =
    supportFragmentManager.beginTransaction().apply {
        replace(containerId, fragment)
        commit()
    }