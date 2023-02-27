package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netflix.databinding.ActivityRegistro2Binding
import com.google.firebase.auth.FirebaseAuth

class Registro2 : AppCompatActivity() {
    lateinit var binding: ActivityRegistro2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textCorreo.setText(intent.getStringExtra("CORREO"))
        registro()
        goIniciar()
    }

    private fun registro(){
        binding.botonContinuar.setOnClickListener{
            if (binding.textCorreo.text!!.isNotEmpty() && binding.textPass.text!!.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.textCorreo.text.toString(),
                    binding.textPass.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent= Intent(this, Login::class.java)
                        startActivity(intent)
                    }else{
                        binding.textInputLayout3.boxStrokeColor= getColor(R.color.red)
                    }
                }
            }
        }
    }

    private fun goIniciar(){
        binding.iniciarSesion2.setOnClickListener {
            val intent= Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}