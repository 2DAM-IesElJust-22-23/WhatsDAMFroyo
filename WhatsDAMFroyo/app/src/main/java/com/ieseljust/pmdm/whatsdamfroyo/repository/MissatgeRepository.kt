package com.ieseljust.pmdm.whatsdamfroyo.repository

import com.ieseljust.pmdm.whatsdamfroyo.model.Missatge
import com.ieseljust.pmdm.whatsdamfroyo.model.Missatges

class MissatgeRepository private constructor(){ // El constructor primari serà privat,
    // de manera que només es podrà
    // invocar des de la pròpia classe.

    // Aci ve la màgia del singleton:
    // Creem un objecte complementari (companion/estàtic) que continga la
    // instància única de la classe, i el mètode getInstance, per
    // tal d'obtenir aquesta.
    // Si és la primera vegada que s'invoca (i per tant la instància
    // de la classe no existeix), es crea aquesta instància.
    // Si no és la primera vegada que s'invoca (i per tant la instància
    // sí que existeix), el que fem, simplement és retornar-la.

    companion object {
        // Referencia a la propia instancia de la classe
        private var INSTANCE: MissatgeRepository? = null

        // Metode per obtenir la referencia a aquesta instancia
        fun getInstance(): MissatgeRepository {
            if (INSTANCE == null) {
                //INSTANCE = ContacteRepository(context)
                INSTANCE = MissatgeRepository()
            }
            return INSTANCE!!
        }
    }

    // Mètodes que ofereix aquest API del repositori:

    fun getMissatges() = Missatges.MissatgesObj.llistaMissatges
    fun getNumMissatges() = Missatges.MissatgesObj.llistaMissatges.size
    fun add(nomUsuari: String?, text: String) { Missatges.MissatgesObj.afegirMissatge(nomUsuari, text)}
    fun remove(c: Missatge) = Missatges.MissatgesObj.llistaMissatges.remove(c)

}


