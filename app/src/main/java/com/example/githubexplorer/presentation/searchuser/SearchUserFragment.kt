package com.example.githubexplorer.presentation.searchuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.githubexplorer.databinding.FragmentSearchBinding
import com.example.githubexplorer.domain.entity.UserEntity
import com.example.githubexplorer.presentation.utils.textChanges
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchUserFragment : Fragment(), SearchUserAdapter.OnItemClickListener {
    companion object {
        fun newInstance() = SearchUserFragment()
    }

    private val viewModel: SearchUserViewModel by viewModels()
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val searchUserAdapter = SearchUserAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = searchUserAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    binding.searchView
                        .editText
                        .textChanges()
                        .collect { text ->
                            viewModel.onQueryChanged(text.toString())
                        }
                }

                launch {
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
                            searchUserAdapter.submitList(state.data.users)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        binding.recyclerView.adapter = null
        _binding = null
        super.onDestroyView()
    }

    override fun onItemClick(user: UserEntity) {
        viewModel.onUserClicked(user)
    }
}