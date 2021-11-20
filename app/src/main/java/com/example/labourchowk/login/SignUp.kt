package com.example.labourchowk.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.labourchowk.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child(("profile"))

        register()
    }

    private fun register() {
        RegisterBtn.setOnClickListener {
            if (TextUtils.isEmpty(EmailEtR.text.toString())) {
                EmailEtR.setError("Please enter emailId")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(PasswordEtR.text.toString())) {
                PasswordEtR.setError("Please enter password")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(ConfirmEdit.text.toString())) {
                ConfirmEdit.setError("Please enter confirm password")
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(
                EmailEtR.text.toString(),
                PasswordEtR.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val currentUser = auth.currentUser
                        val currentUserDb = databaseReference?.child(currentUser?.uid!!)
                        currentUserDb?.child("email")?.setValue(EmailEtR.text.toString())

                        Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show()
                        finish()

                    } else {
                        Toast.makeText(
                            this,
                            "Registration failed, please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

        signTv.setOnClickListener{
            startActivity(Intent(this,LoginScreen::class.java))
            finish()
        }
    }


}