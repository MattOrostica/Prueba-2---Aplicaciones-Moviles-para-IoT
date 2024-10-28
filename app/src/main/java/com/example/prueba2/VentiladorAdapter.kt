package com.example.prueba2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class VentiladorAdapter(context: Context, private val ventiladores: List<Map<String, String>>) :
    ArrayAdapter<Map<String, String>>(context, android.R.layout.simple_list_item_2, ventiladores) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(android.R.layout.simple_list_item_2, parent, false)

        val ventilador = ventiladores[position]

        //Muestra el nombre y la velocidad
        val text1 = view.findViewById<TextView>(android.R.id.text1)
        val text2 = view.findViewById<TextView>(android.R.id.text2)

        text1.text = ventilador["nombre"]
        text2.text = "Velocidad: ${ventilador["velocidad"]}, Estado: ${ventilador["estado"]}"

        return view
    }
}
