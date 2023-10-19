package com.ieseljust.pmdm.whatsdamfroyo

class Missatges (val nomUsuari: String, val text: String){
    object MissatgesObj{
        val llistaMissatges = mutableListOf<Missatge>()
        fun afegirMissatge(nomUsuari: String, text: String){
            val missatge = Missatge(nomUsuari, text)
            llistaMissatges.add(missatge)
        }
    }






}