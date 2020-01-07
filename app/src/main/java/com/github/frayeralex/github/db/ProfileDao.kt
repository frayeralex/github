package com.github.frayeralex.github.db

import androidx.room.*

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_table WHERE id=:id")
    suspend fun loadById(id: Int): ProfileEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profile: ProfileEntity)

    @Delete
    suspend fun delete(profile: ProfileEntity)
}