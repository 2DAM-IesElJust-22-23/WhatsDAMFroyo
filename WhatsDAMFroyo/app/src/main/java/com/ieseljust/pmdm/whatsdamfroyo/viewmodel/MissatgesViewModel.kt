package com.ieseljust.pmdm.whatsdamfroyo.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ieseljust.pmdm.whatsdamfroyo.model.Missatge
import com.ieseljust.pmdm.whatsdamfroyo.model.Missatges
import com.ieseljust.pmdm.whatsdamfroyo.repository.MissatgeRepository

class MissatgesViewModel(application: Application): AndroidViewModel(application){
    /* Propietats del ViewModel */

    val _adaptador = MutableLiveData<AdaptadorMissatge>().apply{
        value= AdaptadorMissatge(MissatgeRepository.getInstance().getMissatges())

    }

    public fun add(nom: String?, text: String){
         MissatgeRepository.getInstance().add(nom, text )
         _adaptador.value?.notifyItemInserted(MissatgeRepository.getInstance().getNumMissatges()-1)

    }
}