package com.example.parcelablekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setTitle("Activity Two")

        val intent=intent;
        val student:Student=intent.getParcelableExtra<Student>("example item")

        Toast.makeText(this,student.surname,Toast.LENGTH_SHORT).show()



    }
}