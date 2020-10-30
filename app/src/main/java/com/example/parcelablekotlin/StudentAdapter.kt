package com.example.parcelablekotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    lateinit var mListener:OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener:OnItemClickListener){
        mListener=listener
    }


    class StudentViewHolder(itemView: View,listener:OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var tv_name = itemView.findViewById<TextView>(R.id.textView)
        var tv_surname = itemView.findViewById<TextView>(R.id.textView2)

        init {
            itemView.setOnClickListener(View.OnClickListener {

                listener.onItemClick(adapterPosition)

            })
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.student_viewholder, parent, false)
        return StudentViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        holder.imageView.setImageResource(students.get(position).imageResource)
        holder.tv_name.setText(students.get(position).name)
        holder.tv_surname.setText(students.get(position).surname)

    }

    override fun getItemCount(): Int {
        return students.size
    }
}