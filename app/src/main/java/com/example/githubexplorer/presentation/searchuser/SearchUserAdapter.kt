package com.example.githubexplorer.presentation.searchuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.request.crossfade
import com.example.githubexplorer.databinding.ItemUserBinding
import com.example.githubexplorer.domain.entity.UserEntity
import com.example.githubexplorer.presentation.utils.loadCircularImage

class SearchUserAdapter(
    private val listener: OnItemClickListener
) : ListAdapter<UserEntity, SearchUserAdapter.SearchUserViewHolder>(SearchUserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchUserViewHolder {
        return SearchUserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchUserViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class SearchUserViewHolder(
        private var binding: ItemUserBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val user = getItem(position)
                    listener.onItemClick(user)
                }
            }
        }

        fun bind(item: UserEntity) {
            binding.apply {
                login.text = item.login
                image.loadCircularImage(item.icon) {
                    crossfade(true)
                }
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(user: UserEntity)
    }
}

