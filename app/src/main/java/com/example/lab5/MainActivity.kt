package com.example.lab5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.Post
import com.example.lab5.JsonReader

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PostAdapter()
        recyclerView.adapter = adapter

        loadData()
    }

    private fun loadData() {
        val posts: List<Post> = JsonReader.readPosts(this)

        Log.d("MainActivity", "Loaded ${posts.size} posts")

        adapter.setPosts(posts)
    }

}