package eni.testskotlin.demofragments.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Utilisateur(var nom : String, var prenom : String, var age : Int) : Parcelable