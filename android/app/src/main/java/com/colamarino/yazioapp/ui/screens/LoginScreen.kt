
package com.colamarino.yazioapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onLogin:(String,String)->Unit){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text("Accedi a Yazio", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value=email, onValueChange={email=it}, label={ Text("Email") }, modifier=Modifier.fillMaxWidth())
        OutlinedTextField(value=password, onValueChange={password=it}, label={ Text("Password") }, visualTransformation= PasswordVisualTransformation(), modifier=Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        Button(onClick={ onLogin(email,password) }, modifier=Modifier.fillMaxWidth()){ Text("Login") }
    }
}
