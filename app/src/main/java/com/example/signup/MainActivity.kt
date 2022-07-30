package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var tvSignUp:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName=findViewById(R.id.etName)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        tvSignUp=findViewById(R.id.tvSignUp)
        btnLogin.setOnClickListener{
            var name=etName.text.toString()
            var Password=etPassword.text.toString()
            if(name.isNullOrEmpty()==true){
                etName.error=resources.getString(R.string.enter_name)
                etName.requestFocus()

            }
            else if(Password.isNullOrEmpty()==true){
                etPassword.error=resources.getString(R.string.enter_pass)
                etPassword.requestFocus()
            }
            else if (Password.length<6){
                etPassword.error=resources.getString(R.string.pass_length)
            }
            else {
                Toast.makeText(this, resources.getString(R.string.login_success), Toast.LENGTH_LONG).show()
            }
            tvSignUp.setOnClickListener {
                var intent2= Intent(this,tvSignUp::class.java)
                startActivity(intent2)
            }
        }

    }
}