package com.ieschabas.sportshub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.ui.components.MyButton
import com.ieschabas.sportshub.ui.components.MySwitch
import com.ieschabas.sportshub.ui.components.MyTextField
import com.ieschabas.sportshub.ui.components.MyTopAppBar
import com.ieschabas.sportshub.ui.screens.auth.AuthUiState
import com.ieschabas.sportshub.ui.screens.auth.AuthViewModel
import com.ieschabas.sportshub.ui.theme.AzulPetroleo

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    val uiState by viewModel.uiState.collectAsState()

    // Navegar a home cuando el login sea exitoso
    LaunchedEffect(uiState) {
        if (uiState is AuthUiState.Success) {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
            viewModel.resetState()
        }
    }

    Scaffold(
        topBar = { MyTopAppBar(title = "Acceso") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.logo_chabas),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(150.dp)
                    .padding(bottom = 32.dp)
            )
            Spacer(modifier = Modifier.weight(0.5f))

            MyTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                isEmail = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Contraseña",
                isPassword = true
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Mensaje de error
            if (uiState is AuthUiState.Error) {
                Text(
                    text = (uiState as AuthUiState.Error).message,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                MySwitch(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it },
                    label = "Recordarme"
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            if (uiState is AuthUiState.Loading) {
                CircularProgressIndicator()
            } else {
                MyButton(
                    text = "Entrar",
                    onClick = { viewModel.login(email, password) },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("¿No tienes cuenta?")
                TextButton(onClick = { navController.navigate("register") }) {
                    Text("Regístrate", color = AzulPetroleo)
                }
            }
            Spacer(modifier = Modifier.weight(1.5f))
        }
    }
}
