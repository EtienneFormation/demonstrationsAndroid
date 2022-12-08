package eni.testskotlin.room

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import eni.testskotlin.room.bo.Personne
import eni.testskotlin.room.dao.AppDatabase
import eni.testskotlin.room.dao.PersonneDAO
import kotlinx.coroutines.launch

class PersonneVM(val dao: PersonneDAO) : ViewModel() {
    val personne = MutableLiveData<Personne>()

    operator fun get(id:Long) {
        viewModelScope.launch { personne.value = dao.get(id) }
    }

    fun add(personne: Personne) : LiveData<Long> {
        val result = MutableLiveData<Long>()

        viewModelScope.launch {
            result.value = dao.insert(personne)
        }

        return result
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])

                return PersonneVM(
                    AppDatabase.getInstance(application.applicationContext).personneDao()
                ) as T
            }
        }
    }
}