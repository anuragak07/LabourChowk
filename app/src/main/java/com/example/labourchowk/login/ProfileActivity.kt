package com.example.labourchowk.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.labourchowk.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child(("profile"))
        loadProfile()
    }

    private fun loadProfile() {
        val user=auth.currentUser
        emailTv.text=user?.email
        val userreference= databaseReference?.child(user?.uid!!)
        userreference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                emailTv.text=snapshot.child("email").value.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        LogoutBtn.setOnClickListener{
            auth.signOut()
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this,LoginScreen::class.java))
            finish()
        }
    }
}