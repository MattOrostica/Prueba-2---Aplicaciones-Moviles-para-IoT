package com.example.prueba2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActualizarActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etVelocidad: EditText
    private lateinit var etEstado: EditText
    private lateinit var btnActualizar: Button

    private var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)

        etNombre = findViewById(R.id.etNombre)
        etVelocidad = findViewById(R.id.etVelocidad)
        etEstado = findViewById(R.id.etEstado)
        btnActualizar = findViewById(R.id.btnActualizar)

        // Obtener la posición del ventilador a actualizar
        position = intent.getIntExtra("POSITION", -1)

        // Cargar los datos del ventilador a actualizar
        cargarDatosVentilador()

        btnActualizar.setOnClickListener {
            actualizarVentilador()
        }
    }

    private fun cargarDatosVentilador() {
        val ventilador = DataManager.obtenerVentilador(position)
        etNombre.setText(ventilador["nombre"])
        etVelocidad.setText(ventilador["velocidad"])
        etEstado.setText(ventilador["estado"])
    }

    private fun actualizarVentilador() {
        val nombre = etNombre.text.toString()
        val velocidad = etVelocidad.text.toString()
        val estado = etEstado.text.toString()

        if (nombre.isEmpty() || velocidad.isEmpty() || estado.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear un nuevo Map con los datos actualizados
        val ventiladorActualizado = mapOf(
            "nombre" to nombre,
            "velocidad" to velocidad,
            "estado" to estado
        )

        // Actualizar el ventilador en DataManager
        DataManager.actualizarVentilador(position, ventiladorActualizado)

        Toast.makeText(this, "Ventilador actualizado", Toast.LENGTH_SHORT).show()
        finish()
    }
}
