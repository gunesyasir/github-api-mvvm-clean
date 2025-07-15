package com.example.githubexplorer.data.remote.mapper

import com.example.githubexplorer.data.remote.model.Plan
import com.example.githubexplorer.data.remote.model.User
import com.example.githubexplorer.data.remote.model.UsersSearchResponse
import com.example.githubexplorer.domain.entity.PlanEntity
import com.example.githubexplorer.domain.entity.UserEntity
import com.example.githubexplorer.domain.entity.UsersSearchEntity
import javax.inject.Inject

class UserSearchMapper @Inject constructor() : Mapper<UsersSearchResponse, UsersSearchEntity> {

    override fun UsersSearchResponse.toEntity(): UsersSearchEntity {
        return UsersSearchEntity(
            totalCount = totalCount,
            incompleteResults = incompleteResults,
            users = items.map { it.toEntity() }
        )
    }

    override fun UsersSearchEntity.toModel(): UsersSearchResponse {
        return UsersSearchResponse(
            totalCount = totalCount,
            incompleteResults = incompleteResults,
            items = users.map { it.toModel() }
        )
    }
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        login = this.login,
        id = this.id,
        nodeId = this.nodeId,
        icon = this.avatarUrl,
        gravatarId = this.gravatarId,
        url = this.url,
        htmlUrl = this.htmlUrl,
        followersUrl = this.followersUrl,
        followingUrl = this.followingUrl,
        gistsUrl = this.gistsUrl,
        starredUrl = this.starredUrl,
        subscriptionsUrl = this.subscriptionsUrl,
        organizationsUrl = this.organizationsUrl,
        reposUrl = this.reposUrl,
        eventsUrl = this.eventsUrl,
        receivedEventsUrl = this.receivedEventsUrl,
        type = this.type,
        siteAdmin = this.siteAdmin,
        name = this.name,
        company = this.company,
        blog = this.blog,
        location = this.location,
        email = this.email,
        notificationEmail = this.notificationEmail,
        hireable = this.hireable,
        bio = this.bio,
        twitterUsername = this.twitterUsername,
        publicRepos = this.publicRepos,
        publicGists = this.publicGists,
        followers = this.followers,
        following = this.following,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        privateGists = this.privateGists,
        totalPrivateRepos = this.totalPrivateRepos,
        ownedPrivateRepos = this.ownedPrivateRepos,
        diskUsage = this.diskUsage,
        collaborators = this.collaborators,
        twoFactorAuthentication = this.twoFactorAuthentication,
        businessPlus = this.businessPlus,
        ldapDn = this.ldapDn,
        plan = this.plan?.toEntity()
    )
}

fun UserEntity.toModel(): User {
    return User(
        login = this.login,
        id = this.id,
        nodeId = this.nodeId,
        avatarUrl = this.icon,
        gravatarId = this.gravatarId,
        url = this.url,
        htmlUrl = this.htmlUrl,
        followersUrl = this.followersUrl,
        followingUrl = this.followingUrl,
        gistsUrl = this.gistsUrl,
        starredUrl = this.starredUrl,
        subscriptionsUrl = this.subscriptionsUrl,
        organizationsUrl = this.organizationsUrl,
        reposUrl = this.reposUrl,
        eventsUrl = this.eventsUrl,
        receivedEventsUrl = this.receivedEventsUrl,
        type = this.type,
        siteAdmin = this.siteAdmin,
        name = this.name,
        company = this.company,
        blog = this.blog,
        location = this.location,
        email = this.email,
        notificationEmail = this.notificationEmail,
        hireable = this.hireable,
        bio = this.bio,
        twitterUsername = this.twitterUsername,
        publicRepos = this.publicRepos,
        publicGists = this.publicGists,
        followers = this.followers,
        following = this.following,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        privateGists = this.privateGists,
        totalPrivateRepos = this.totalPrivateRepos,
        ownedPrivateRepos = this.ownedPrivateRepos,
        diskUsage = this.diskUsage,
        collaborators = this.collaborators,
        twoFactorAuthentication = this.twoFactorAuthentication,
        businessPlus = this.businessPlus,
        ldapDn = this.ldapDn,
        plan = this.plan?.toModel()
    )
}

fun Plan.toEntity(): PlanEntity {
    return PlanEntity(
        collaborators = this.collaborators,
        name = this.name,
        space = this.space,
        privateRepos = this.privateRepos
    )
}

fun PlanEntity.toModel(): Plan {
    return Plan(
        collaborators = this.collaborators,
        name = this.name,
        space = this.space,
        privateRepos = this.privateRepos
    )
}