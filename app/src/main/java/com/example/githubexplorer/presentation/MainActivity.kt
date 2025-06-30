package com.example.githubexplorer.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubexplorer.R
import com.example.githubexplorer.databinding.ActivityMainBinding
import com.example.githubexplorer.presentation.searchuser.SearchUserFragment
import com.example.githubexplorer.presentation.utils.setFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val searchUserFragment = SearchUserFragment.newInstance()
        setFragment(R.id.container, searchUserFragment)
    }
}