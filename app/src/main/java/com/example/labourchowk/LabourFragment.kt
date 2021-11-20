package com.example.labourchowk

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class LabourFragment : Fragment(R.layout.fragment_labour),Labourlistener {

    private lateinit var dref: DatabaseReference
    private lateinit var recycler2: RecyclerView
    private lateinit var datalist1:ArrayList<LabourModel>

    override fun onStart() {
        super.onStart()
        getdata3()

    }
    private fun getdata3() {
        datalist1= arrayListOf<LabourModel>()
        recycler2= view?.findViewById(R.id.recyclelab)!!
        recycler2.layoutManager= LinearLayoutManager(context)
        recycler2.setHasFixedSize(false)
        dref= FirebaseDatabase.getInstance().getReference("LabourData")
        dref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user2=usersnapshot.getValue(LabourModel::class.java)
                        datalist1.add(user2!!)
                    }
                    recycler2.adapter= LabourAdapter(context!!,datalist1,this@LabourFragment)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    override fun onclick(position: Int, model: LabourModel) {
        val intent=Intent(context,labDetailActivity::class.java)
        intent.putExtra("imgg",model.Image1)
        intent.putExtra("naam",model.name2)
        intent.putExtra("placee",model.place2)
        intent.putExtra("skill",model.Reqd1)
        intent.putExtra("rs",model.charge)
        startActivity(intent)
    }

}