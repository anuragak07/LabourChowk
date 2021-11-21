package com.example.labourchowk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HomeAdapter(val context: Context, private val datalist:ArrayList<HoimModel>, val onClickListener: HomeListener):RecyclerView.Adapter<HomeAdapter.MyviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.forhomelayout,parent,false)
        return MyviewHolder(view,onClickListener)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val model: HoimModel =datalist[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


    class MyviewHolder(val view: View, val onClickListener: HomeListener): RecyclerView.ViewHolder(view){


        val name1: TextView =view.findViewById(R.id.tvhomename)
        val Image: ImageView =view.findViewById(R.id.civcircle1)
        val place1:TextView=view.findViewById(R.id.tvhomeplace)
        val reqd:TextView=view.findViewById(R.id.tvreqtype)
        val distance1:TextView=view.findViewById(R.id.tvdistance)

        val relativeLayout: RelativeLayout = view.findViewById(R.id.relateitem)

        fun  setData(usermodel: HoimModel){
            name1.text=usermodel.name1
            // Glide.with(Image).load(usermodel.Image).into(Image)
            Glide.with(Image).load(usermodel.Image).into(Image)
            place1.text=usermodel.place1
            reqd.text=usermodel.Reqd
            distance1.text=usermodel.distance1
            relativeLayout.setOnClickListener {
                onClickListener.onitemclicked(adapterPosition,usermodel)
            }

        }

    }
}