package eni.testskotlin.room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import eni.testskotlin.R
import eni.testskotlin.databinding.ActivityRoomBinding
import eni.testskotlin.room.bo.Personne

class RoomActivity : AppCompatActivity() {
    val viewmodel : PersonneVM by viewModels { PersonneVM.Factory }
    lateinit var databinding : ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        databinding = DataBindingUtil.setContentView(this, R .layout.activity_room)
        databinding.vm = viewmodel
        databinding.lifecycleOwner = this

        val id = viewmodel.add(Personne(0L, "CASSIN", "Etienne"))

        id.observe(this) { viewmodel[it] }

        databinding.btnAjouter.setOnClickListener{
            val newId = this.viewmodel.add(Personne(0L, "BONNEAU", "Argann"))
            newId.observe(this) { viewmodel[it]}
        }
    }
}