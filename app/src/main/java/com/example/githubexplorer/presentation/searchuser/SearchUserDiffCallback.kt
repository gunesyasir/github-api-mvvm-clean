package com.example.githubexplorer.presentation.searchuser

import androidx.recyclerview.widget.DiffUtil
import com.example.githubexplorer.domain.entity.UserEntity

class SearchUserDiffCallback : DiffUtil.ItemCallback<UserEntity>() {
    override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
        return oldItem == newItem
    }
}
