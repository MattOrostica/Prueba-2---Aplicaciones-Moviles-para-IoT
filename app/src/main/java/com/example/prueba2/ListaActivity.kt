package com.example.prueba2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ListaActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var btnAgregar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        listView = findViewById(R.id.listView)
        btnAgregar = findViewById(R.id.btnAgregar)

        cargarLista()

        btnAgregar.setOnClickListener {

        }

        // Listener para los elementos de la lista
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // Intentar actualizar el ventilador
            val intent = Intent(this, ActualizarActivity::class.java)
            intent.putExtra("POSITION", position)
            startActivity(intent)
        }
    }

    private fun cargarLista() {
        val ventiladores = DataManager.obtenerVentiladores()
        val adapter = VentiladorAdapter(this, ventiladores)
        listView.adapter = adapter
    }
}
