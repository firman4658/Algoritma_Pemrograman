package com.example.algoritma_pemrograman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registrasi : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSingUp: ImageButton
    private lateinit var backlogin: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)
        auth = FirebaseAuth.getInstance()
        etEmail= findViewById(R.id.editTextTextEmailAddress)
        etPassword= findViewById(R.id.editTextTextPassword)
        btnSingUp = findViewById(R.id.imageView6)
        btnSingUp.setOnClickListener {
            val email= etEmail.text.toString().trim()
            val password= etPassword.text.toString().trim()
            if (email.isEmpty() ){
                etEmail.error="Masukkan Email"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                etEmail.error="Email tidak valid"
                etEmail.requestFocus()
                return@setOnClickListener
            }


            if (password.isEmpty() || password.length<6){
                etPassword.error="Password harus lebih 6 karakter"
                return@setOnClickListener
            }

            registerUser(email,password)

        }

        backlogin.setOnClickListener {
            startActivity(Intent(this@Registrasi, Registrasi::class.java))
        }
    }
    private fun registerUser(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Intent(this@Registrasi, Menu::class.java ).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)

                    }
                }else{
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }

    }

}
