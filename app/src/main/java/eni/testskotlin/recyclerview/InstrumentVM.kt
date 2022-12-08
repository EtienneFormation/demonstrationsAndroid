package eni.testskotlin.recyclerview

import androidx.lifecycle.ViewModel
import eni.testskotlin.recyclerview.bo.Instrument

class InstrumentVM : ViewModel() {
    val instruments = arrayListOf(
        Instrument("Guitare", "Corde"),
        Instrument("Harpe", "Corde"),
        Instrument("Haut-bois", "Vent"),
        Instrument("Flute a bec", "Vent"),
        Instrument("Trompette", "Vent"),
        Instrument("Saxophone", "Vent"),
        Instrument("Tuba", "Vent"),
        Instrument("Trombonne", "Vent"),
        Instrument("Batterie", "Percussion"),
        Instrument("Biwa", "Corde"),
        Instrument("Xylophone", "Percussion"),
        Instrument("Triangle", "Percussion"),
        Instrument("Flute traversiere", "Vent"),
        Instrument("Clarinette", "Vent"),
        Instrument("Banjo", "Corde"),
        Instrument("Luth", "Corde"),
        Instrument("Contrebasse", "Corde"),
        Instrument("Tambour", "Percussion")
    )
}