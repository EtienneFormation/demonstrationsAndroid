package eni.testskotlin.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompteurVM : ViewModel() {
    val cpt = MutableLiveData(0)

    fun plusUn() {
        cpt.value = cpt.value?.plus(1)
    }
}