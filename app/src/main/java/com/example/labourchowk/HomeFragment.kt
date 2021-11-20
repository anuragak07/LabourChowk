package com.example.labourchowk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class HomeFragment : Fragment(R.layout.fragment_home),HomeListener {

    private lateinit var dref: DatabaseReference
    private lateinit var recycler1: RecyclerView
    private lateinit var datalist:ArrayList<HoimModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // recycler1=view.findViewById(R.id.recyclehome)

    }

    override fun onStart() {
        super.onStart()
        getdata2()
    }
    private fun getdata2() {
        datalist= arrayListOf<HoimModel>()
        recycler1= view?.findViewById(R.id.recyclehome)!!
        recycler1.layoutManager= LinearLayoutManager(context)
        recycler1.setHasFixedSize(false)
        dref= FirebaseDatabase.getInstance().getReference("homedata")
        dref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user2=usersnapshot.getValue(HoimModel::class.java)
                        datalist.add(user2!!)
                    }
                    recycler1.adapter= HomeAdapter(context!!,datalist,this@HomeFragment)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    override fun onitemclicked(position: Int, homemodel: HoimModel) {

    }

}