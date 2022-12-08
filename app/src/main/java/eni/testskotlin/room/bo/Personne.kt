package eni.testskotlin.room.bo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personne (@PrimaryKey(autoGenerate = true) val id: Long, val nom: String, val prenom: String) {
}