package com.ieseljust.pmdm.whatsdamfroyo

object Missatges {
    var missatges: ArrayList<Missatge>

    private var fontMissatges: ArrayList<Missatge>

    init {
        //  Inicialització de la llista de contactes
        missatges = ArrayList<Missatge>()
        fontMissatges= ArrayList<Missatge>()
    }

    fun add():Boolean{
        if(fontMissatges.size>0){
            missatges.add(fontMissatges[0])
            fontMissatges.removeAt(0)
            return true
        }

        return false

    }






}