package com.example.githubexplorer.presentation.searchuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.githubexplorer.databinding.FragmentSearchBinding
import com.example.githubexplorer.presentation.utils.textChanges
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchUserFragment : Fragment() {
    companion object {
        fun newInstance() = SearchUserFragment()
    }

    private val viewModel: SearchUserViewModel by viewModels()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.apply {
            searchView
                .editText
                .textChanges()
                .drop(1)
                .debounce(500)
                .onEach { text ->
                    viewModel.onSearchTextChanged(text?.toString().orEmpty())
                }
                .launchIn(lifecycleScope)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.userSearchState.collect { state ->
                if (state.isLoading) {
                    // show loading
                } else {
                    // hide loading
                }

                if (state.error != null) {
                    // show error
                }

                if (state.data != null) {
                    // show data
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}