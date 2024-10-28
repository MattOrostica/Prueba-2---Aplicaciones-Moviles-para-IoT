package com.example.prueba2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etVelocidad: EditText
    private lateinit var etEstado: EditText
    private lateinit var buttonAgregar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        etNombre = findViewById(R.id.etNombre)
        etVelocidad = findViewById(R.id.etVelocidad)
        etEstado = findViewById(R.id.etEstado)
        buttonAgregar = findViewById(R.id.buttonAgregar)

        buttonAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val velocidad = etVelocidad.text.toString()
            val estado = etEstado.text.toString()

            val nuevoVentilador = mapOf(
                "nombre" to nombre,
                "velocidad" to velocidad,
                "estado" to estado
            )

            // Agregar el ventilador al DataManager
            DataManager.agregarVentilador(nuevoVentilador)

            finish()
        }
    }
}
