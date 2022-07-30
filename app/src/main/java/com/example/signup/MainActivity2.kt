package com.example.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Patterns
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {

    lateinit var etName:EditText
    lateinit var etEmail:EditText
    lateinit var etNo:EditText
    lateinit var etPass:EditText
    lateinit var etPass2:EditText
    lateinit var etOthers:EditText
    lateinit var rbMale:RadioButton
    lateinit var rbFemale:RadioButton
    lateinit var rbOthers:RadioButton
    lateinit var rbGroup:RadioGroup
    lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        etName=findViewById(R.id.etName)
        etEmail=findViewById(R.id.etEmail)
        etNo=findViewById(R.id.etNo)
        etPass=findViewById(R.id.etPass)
        etPass2=findViewById(R.id.etPass2)
        etOthers=findViewById(R.id.etOthers)
        rbMale=findViewById(R.id.rbMale)
        rbFemale=findViewById(R.id.rbFemale)
        rbOthers=findViewById(R.id.rbOthers)
        rbGroup=findViewById(R.id.rbGroup)
        btnSignup=findViewById(R.id.btnSignup)
        rbGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.rbOthers->{
                    etOthers.visibility=View.VISIBLE
                }

                else->{
                    etOthers.visibility=View.INVISIBLE
                }
            }
        }
        btnSignup.setOnClickListener {
            var name=etName.text.toString()
            var email=etEmail.text.toString()
            var No=etNo.text.toString()
            var pass=etPass.text.toString()
            var pass2=etPass2.text.toString()
            var specify=etOthers.text.toString()

            if (name.isNullOrEmpty()==true){
                etName.error=resources.getString(R.string.enter_name)
                etName.requestFocus()
            }
            else if(Patterns.EMAIL_ADDRESS.matcher(email).matches()==false){
                etEmail.error=resources.getString(R.string.valid_email)
                etEmail.requestFocus()
            }
            else if (No.length<10){
                etNo.error=resources.getString(R.string.no)
                etNo.requestFocus()
            }
            else if(pass.isNullOrEmpty()==true){
                etPass.error=resources.getString(R.string.enter_pass)
                etPass.requestFocus()
            }
            else if(pass2.isNullOrEmpty()==true){
                etPass2.error=resources.getString(R.string.enter_pass2)
                etPass2.requestFocus()
            }
            else if(pass2!=pass){
                etPass2.error=resources.getString(R.string.PAss)
                etPass2.requestFocus()
            }
            else if (etOthers.visibility==View.VISIBLE && specify.isNullOrEmpty()==true){
                etOthers.error=resources.getString(R.string.other)
                etOthers.requestFocus()
            }
            else{
                Toast.makeText(this,R.string.register_success,Toast.LENGTH_SHORT).show()
            }
        }
    }
}