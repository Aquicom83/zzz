
package com.colamarino.yazioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.colamarino.yazioapp.ui.screens.DashboardScreen
import com.colamarino.yazioapp.ui.screens.LoginScreen
import com.colamarino.yazioapp.viewmodel.AuthViewModel

class MainActivity: ComponentActivity(){
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      YazioApp { AppNav() }
    }
  }
}

@Composable
fun AppNav(){
  val nav: NavHostController = rememberNavController()
  val authVm: AuthViewModel = viewModel()
  NavHost(navController = nav, startDestination = "login"){
    composable("login") {
      LoginScreen(
        onLogin = { email, pass -> authVm.login(email, pass){ success -> if(success) nav.navigate("dashboard") } }
      )
    }
    composable("dashboard") {
      DashboardScreen()
    }
  }
}
