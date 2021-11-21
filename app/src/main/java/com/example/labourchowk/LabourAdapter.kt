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

class LabourAdapter(val context: Context, private val datalist:ArrayList<LabourModel>, val onClickListener: Labourlistener):
    RecyclerView.Adapter<LabourAdapter.MylabviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MylabviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.labourlayout, parent, false)
        return MylabviewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: MylabviewHolder, position: Int) {
        val model: LabourModel = datalist[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }


    class MylabviewHolder(val view: View, val onClickListener: Labourlistener) :
        RecyclerView.ViewHolder(view) {


        val name1: TextView = view.findViewById(R.id.tvlabname)
        val Image: ImageView = view.findViewById(R.id.civcircle2)
        val place1: TextView = view.findViewById(R.id.tvlabplace)
        val reqd: TextView = view.findViewById(R.id.tvlabtype)
        val charge:TextView=view.findViewById(R.id.tvchargesrs)
        val distance1: TextView = view.findViewById(R.id.tvdistancelab)

        val relativeLayout: RelativeLayout = view.findViewById(R.id.labourrel)

        fun setData(usermodel: LabourModel) {
            name1.text = usermodel.name2
            // Glide.with(Image).load(usermodel.Image).into(Image)
            Glide.with(Image).load(usermodel.Image1).into(Image)
            place1.text = usermodel.place2
            reqd.text = usermodel.Reqd1
            charge.text=usermodel.charge
            distance1.text = usermodel.distance2
            relativeLayout.setOnClickListener {
                onClickListener.onclick(adapterPosition, usermodel)
            }

        }

    }
}
