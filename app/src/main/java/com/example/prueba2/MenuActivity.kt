package com.example.prueba2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var btnCrear: Button
    private lateinit var btnLeer: Button
    private lateinit var btnActualizar: Button
    private lateinit var btnEliminar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnCrear = findViewById(R.id.btnCrear)
        btnLeer = findViewById(R.id.btnLeer)
        btnActualizar = findViewById(R.id.btnActualizar)
        btnEliminar = findViewById(R.id.btnEliminar)

        btnCrear.setOnClickListener { startActivity(Intent(this, CreateActivity::class.java)) }
        btnLeer.setOnClickListener { startActivity(Intent(this, ListaActivity::class.java)) }
        btnActualizar.setOnClickListener { startActivity(Intent(this, ListaActivity::class.java)) }
        btnEliminar.setOnClickListener { startActivity(Intent(this, ListaActivity::class.java)) }
    }
}
