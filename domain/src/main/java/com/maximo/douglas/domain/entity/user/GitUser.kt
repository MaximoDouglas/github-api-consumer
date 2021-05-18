package com.maximo.douglas.domain.entity.user

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GitUser(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("login")
    val login: String
) : Serializable