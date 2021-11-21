package com.example.labourchowk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_dett.*

class DettActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dett)

        Glide.with(civprofile).load(intent.getStringExtra("img")).into(civprofile)
        tvprofname.text=intent.getStringExtra("naam")
        tvprofplace.text=intent.getStringExtra("place")
        tvtypeprof.text=intent.getStringExtra("reqdd")
    }
}