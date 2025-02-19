package com.example.hola_mundo_xml

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var boton_pulsar: Button
    lateinit var cajon_de_texto: TextView
    lateinit var cajon_de_texto_a_introducir: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cajon_de_texto = findViewById(R.id.cajon_texto_vista)
        boton_pulsar = findViewById(R.id.boton_magico)
        cajon_de_texto_a_introducir = findViewById(R.id.entrada_de_texto)

        boton_pulsar.setOnClickListener{
            mandar_texto()
        }
    }

    fun mandar_texto(){
        cajon_de_texto.text = cajon_de_texto_a_introducir.text
        cajon_de_texto_a_introducir.setText("")
    }
}