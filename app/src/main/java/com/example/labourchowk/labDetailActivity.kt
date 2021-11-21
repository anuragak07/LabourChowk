package com.example.labourchowk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_dett.*
import kotlinx.android.synthetic.main.activity_lab_detail.*

class labDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_detail)


        Glide.with(civprofilelab).load(intent.getStringExtra("imgg")).into(civprofilelab)
        tvprofnamelab.text=intent.getStringExtra("naam")
        tvprofplacelab.text=intent.getStringExtra("placee")
        tvtypeproflab.text=intent.getStringExtra("skill")
        tvchargers.text=intent.getStringExtra("rs")
    }
}