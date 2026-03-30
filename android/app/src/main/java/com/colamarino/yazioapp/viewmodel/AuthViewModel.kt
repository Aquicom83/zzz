
package com.colamarino.yazioapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.colamarino.yazioapp.data.repository.YazioRepository
import kotlinx.coroutines.launch

class AuthViewModel(app: Application): AndroidViewModel(app){
    private val repo = YazioRepository(app.applicationContext)

    fun login(email:String, password:String, onResult:(Boolean)->Unit){
        viewModelScope.launch {
            try {
                val ok = repo.login(email, password)
                onResult(ok)
            } catch (e: Exception){
                onResult(false)
            }
        }
    }
}
