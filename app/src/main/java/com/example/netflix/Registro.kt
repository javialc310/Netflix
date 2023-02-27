package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isEmpty
import com.example.netflix.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botones()
    }

    fun botones(){
        binding.botonEmpezarRegistro3.setOnClickListener {
            if (binding.textCorreo.text!!.isEmpty()){
                binding.textoError.text= "El correo es obligatorio."
                binding.textoError.setTextColor(getColor(R.color.red))
                binding.textInputLayout.boxStrokeColor= getColor(R.color.red)
            }else{
                binding.textInputLayout.boxStrokeColor= getColor(R.color.green)
                val intent= Intent(this, Registro2::class.java)
                intent.putExtra("CORREO", binding.textCorreo.text.toString())
                startActivity(intent)
            }
        }
        binding.imagenCruz.setOnClickListener {
            val intent= Intent(this, ActivityEmpezar::class.java)
            startActivity(intent)
        }
    }
}