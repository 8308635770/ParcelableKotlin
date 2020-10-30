package com.example.parcelablekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var studentList=ArrayList<Student>()
    lateinit var adapter:StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentList.add(Student(R.drawable.ic_launcher_background,"shivam","yash1"))
        studentList.add(Student(R.drawable.ic_launcher_background,"shivam","yash2"))
        studentList.add(Student(R.drawable.ic_launcher_background,"shivam","yash2"))
        studentList.add(Student(R.drawable.ic_launcher_background,"shivam","yash4"))

        recyclerView=findViewById(R.id.recycler_view)

        adapter= StudentAdapter(studentList)

        recyclerView.layoutManager= LinearLayoutManager(this)

        adapter.setOnItemClickListener(object :StudentAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent=Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("example item",studentList.get(position))
                startActivity(intent)

//                startActivity(Intent(this@MainActivity,MainActivity2::class.java))
            }

        })

        recyclerView.adapter=adapter

    }
}