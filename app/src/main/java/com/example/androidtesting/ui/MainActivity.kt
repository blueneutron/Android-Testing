package com.example.androidtesting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtesting.R
import com.example.androidtesting.data.local.RecipeStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recipes);
        val recipeStore = RecipeStore(this, "recipes")
        val recipeAdapter = RecipeAdapter(recipeStore)
        recyclerView.adapter = recipeAdapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}