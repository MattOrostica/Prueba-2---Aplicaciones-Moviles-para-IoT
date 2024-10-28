package com.example.prueba2

object DataManager {
    private val ventiladores = mutableListOf<Map<String, String>>()

    // Método para agregar un ventilador
    fun agregarVentilador(ventilador: Map<String, String>) {
        ventiladores.add(ventilador)
    }

    // Método para obtener todos los ventiladores
    fun obtenerVentiladores(): List<Map<String, String>> {
        return ventiladores
    }

    // Método para obtener un ventilador por su posición
    fun obtenerVentilador(position: Int): Map<String, String> {
        return ventiladores[position]
    }

    // Método para actualizar un ventilador
    fun actualizarVentilador(position: Int, ventilador: Map<String, String>) {
        ventiladores[position] = ventilador
    }

    // Método para eliminar un ventilador
    fun eliminarVentilador(position: Int) {
        ventiladores.removeAt(position)
    }
}
