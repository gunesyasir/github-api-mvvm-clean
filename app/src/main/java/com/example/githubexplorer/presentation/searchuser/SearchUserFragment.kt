package com.example.githubexplorer.presentation.searchuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.githubexplorer.databinding.FragmentSearchBinding
import com.example.githubexplorer.domain.entity.UserEntity
import com.example.githubexplorer.presentation.base.BaseFragment
import com.example.githubexplorer.presentation.utils.textChanges
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchUserFragment : BaseFragment<FragmentSearchBinding>(), SearchUserAdapter.OnItemClickListener {
    companion object {
        fun newInstance() = SearchUserFragment()
    }

    private val viewModel: SearchUserViewModel by viewModels()

    private val searchUserAdapter = SearchUserAdapter(this)

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun FragmentSearchBinding.initialize() {
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
        super.onDestroyView()
    }

    override fun onItemClick(user: UserEntity) {
        viewModel.onUserClicked(user)
    }
}