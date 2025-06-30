package com.example.githubexplorer.data.remote.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    val login: String,

    @SerializedName("id")
    val id: Long,

    @SerializedName("node_id")
    val nodeId: String,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("gravatar_id")
    val gravatarId: String?,

    @SerializedName("url")
    val url: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("followers_url")
    val followersUrl: String,

    @SerializedName("following_url")
    val followingUrl: String,

    @SerializedName("gists_url")
    val gistsUrl: String,

    @SerializedName("starred_url")
    val starredUrl: String,

    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String,

    @SerializedName("organizations_url")
    val organizationsUrl: String,

    @SerializedName("repos_url")
    val reposUrl: String,

    @SerializedName("events_url")
    val eventsUrl: String,

    @SerializedName("received_events_url")
    val receivedEventsUrl: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("site_admin")
    val siteAdmin: Boolean,

    @SerializedName("name")
    val name: String?,

    @SerializedName("company")
    val company: String?,

    @SerializedName("blog")
    val blog: String?,

    @SerializedName("location")
    val location: String?,

    @SerializedName("email")
    val email: String?,

    @SerializedName("notification_email")
    val notificationEmail: String?,

    @SerializedName("hireable")
    val hireable: Boolean?,

    @SerializedName("bio")
    val bio: String?,

    @SerializedName("twitter_username")
    val twitterUsername: String?,

    @SerializedName("public_repos")
    val publicRepos: Int?,

    @SerializedName("public_gists")
    val publicGists: Int?,

    @SerializedName("followers")
    val followers: Int?,

    @SerializedName("following")
    val following: Int?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("updated_at")
    val updatedAt: String?,

    @SerializedName("private_gists")
    val privateGists: Int?,

    @SerializedName("total_private_repos")
    val totalPrivateRepos: Int?,

    @SerializedName("owned_private_repos")
    val ownedPrivateRepos: Int?,

    @SerializedName("disk_usage")
    val diskUsage: Int?,

    @SerializedName("collaborators")
    val collaborators: Int?,

    @SerializedName("two_factor_authentication")
    val twoFactorAuthentication: Boolean?,

    @SerializedName("business_plus")
    val businessPlus: Boolean?,

    @SerializedName("ldap_dn")
    val ldapDn: String?,

    @SerializedName("plan")
    val plan: Plan?
)

data class Plan(
    @SerializedName("collaborators")
    val collaborators: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("space")
    val space: Int,

    @SerializedName("private_repos")
    val privateRepos: Int
)


