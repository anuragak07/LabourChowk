package com.example.labourchowk.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.labourchowk.MainActivity
import com.example.labourchowk.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        auth = FirebaseAuth.getInstance()
        login()
        SignUpTv.setOnClickListener{
            startActivity(Intent(this,SignUp::class.java))
        }
    }

    private fun login() {
        LoginBtn.setOnClickListener{
            if (TextUtils.isEmpty(EmailEt.text.toString())) {
                EmailEt.setError("Please enter emailId")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(PasswordEt.text.toString())) {
                PasswordEt.setError("Please enter password")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(EmailEt.text.toString(),PasswordEt.text.toString())
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(
                            this,
                            "Wrong emailId or Password, please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}