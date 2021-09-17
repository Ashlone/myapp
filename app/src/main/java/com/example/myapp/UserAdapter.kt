package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
    val itemView=LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return MyViewHolder(itemView)
    }

    class MyViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name)
        val sport:TextView=itemView.findViewById(R.id.sport)
    }


    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
       val currentitem=userList[position]
        holder.name.text=currentitem.name
        holder.sport.text=currentitem.sport
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}