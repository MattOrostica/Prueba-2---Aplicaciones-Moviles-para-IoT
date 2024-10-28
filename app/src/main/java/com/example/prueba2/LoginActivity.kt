package com.example.prueba2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnIniciarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Inicializa los elementos de la interfaz
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)

        //Configura el botón de iniciar sesión
        btnIniciarSesion.setOnClickListener {
            iniciarSesion()
        }
    }

    private fun iniciarSesion() {
        try {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // Agrega un log para verificar los valores
            Log.d("TAG", "Email: $email, Contraseña: $password")

            // Lógica de inicio de sesión
            if (email.isEmpty() || password.isEmpty()) {
                throw Exception("Email y contraseña no pueden estar vacíos.")
            }

            // Verificar credenciales
            if (email == "usuario@gmail.com" && password == "123456") {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                throw Exception("Credenciales incorrectas.")
            }

        } catch (e: Exception) {
            Log.e("TAG", "Error al iniciar sesión: ${e.message}")
            mostrarMensajeError(e.message ?: "Ocurrió un error, por favor intenta nuevamente.")
        }
    }

    private fun mostrarMensajeError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
