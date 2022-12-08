package eni.testskotlin.room.dao

import androidx.room.*
import eni.testskotlin.room.bo.Personne

@Dao
interface PersonneDAO {
    @Insert
    suspend fun insert(personne: Personne) : Long

    @Query("SELECT * FROM Personne WHERE id = :id")
    suspend fun get(id: Long): Personne

    @Update
    fun update(personne: Personne)

    @Delete
    fun delete(personne: Personne)
}