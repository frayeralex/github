package com.github.frayeralex.github.db

import androidx.room.*

@Entity(tableName = "profile_table")
data class ProfileEntity(
    @PrimaryKey val id: Int,
    val login: String,
    val name: String,
    val url: String,
    val email: String?,
    val location: String?,
    @ColumnInfo(name = "node_id") val nodeId: String,
    @ColumnInfo(name = "avatar_url") val avatarUrl: String,
    @ColumnInfo(name = "html_url") val htmlUrl: String,
    @ColumnInfo(name = "repos_url") val reposUrl: String,
    @ColumnInfo(name = "created_at") val createdAt: String
)