package eni.testskotlin.demofragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import eni.testskotlin.R
import eni.testskotlin.demofragments.bo.Utilisateur
import eni.testskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = Utilisateur("CASSIN", "Etienne", 30)

        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        amb.utilisateur = user

        amb.btnTester.setOnClickListener {
            Toast.makeText(this, user.nom, Toast.LENGTH_SHORT).show()
        }
    }
}