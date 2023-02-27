package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netflix.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        botones()
    }

    fun botones(){
        var intent= Intent(this, Login::class.java)
        binding.imagenFlecha.setOnClickListener {
            intent= Intent(this, ActivityEmpezar::class.java)
            startActivity(intent)
        }

        binding.botonMainMenu.setOnClickListener {
            if (binding.inputEmail.text!!.isNotEmpty() && binding.inputPass.text!!.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.inputEmail.text.toString(),
                    binding.inputPass.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        intent=Intent(this, PaginaPrincipal::class.java)
                        startActivity(intent)
                    }else{
                        binding.textInputLayout4.boxStrokeColor= getColor(R.color.red)
                        binding.textInputLayout5.boxStrokeColor= getColor(R.color.red)
                    }

                }
            }
        }

        binding.buttonVueltaRegistro.setOnClickListener {
            intent= Intent(this, Registro::class.java)
            startActivity(intent)
        }

    }
}