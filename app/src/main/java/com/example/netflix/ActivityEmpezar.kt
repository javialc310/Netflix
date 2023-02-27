package com.example.netflix

import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.netflix.databinding.ActivityEmpezarBinding
import me.relex.circleindicator.CircleIndicator3

class ActivityEmpezar : AppCompatActivity() {
    private var listaTitulo= mutableListOf<String>()
    private var descripcionLista= mutableListOf<String>()
    private var imagenesLista= mutableListOf<Int>()

    lateinit var binding:ActivityEmpezarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEmpezarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager= findViewById<ViewPager2>(R.id.viewPager)
        val indicator= findViewById<CircleIndicator3>(R.id.circulo)
        postToList()
        viewPager.adapter= ViewAdapter(listaTitulo, descripcionLista, imagenesLista)

        indicator.setViewPager(viewPager)
        boton()
    }

    private fun addToList(title: String, descripcion:String, imagen: Int){
        listaTitulo.add(title)
        descripcionLista.add(descripcion)
        imagenesLista.add(imagen)
    }

    private fun postToList(){
        addToList("Todas las películas y series que desees, y mucho más.", "Disfruta donde quieras. Cancela cuando quieras",
        R.drawable.backgroundempezar)
        addToList("Sin contratos liosos", "Suscríbete hoy, cancela cuando quieras.",
            R.drawable.imagen2)
        addToList("Tú decides cómo lo ves", "En tu teléfono, tablet, computadora y TV sin costo extra.",
            R.drawable.imagen1)
        addToList("3, 2, 1 ... ¡Descarga!", "Las descargas solo están disponibles en tus planes sin anuncios.",
            R.drawable.imagen3)
    }

    private fun boton(){
        binding.botonEmpezarRegistro.setOnClickListener {
            val intent= Intent(this, Registro::class.java)
            startActivity(intent)
        }
        binding.iniciarSesion2.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}