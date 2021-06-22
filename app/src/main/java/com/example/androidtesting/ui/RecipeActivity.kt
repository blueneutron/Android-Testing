package com.example.androidtesting.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtesting.R
import com.example.androidtesting.RecipeApplication
import com.example.androidtesting.data.local.RecipeStore

class RecipeActivity : AppCompatActivity(), RecipeContract.View {

    lateinit var recipePresenter: RecipePresenter
    lateinit var titleView: TextView
    lateinit var descriptionView: TextView

    companion object {
        @JvmField
        val KEY_ID: String = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        titleView = findViewById(R.id.title)
        descriptionView = findViewById(R.id.description)

        val recipeStore = RecipeStore(this, "recipes")
        val id = intent.getStringExtra(KEY_ID)
        val recipeApplication = application as RecipeApplication
        val favourites = recipeApplication.favourites
        recipePresenter = RecipePresenter(recipeStore, this, favourites)
        recipePresenter.loadRecipe(id)

        titleView.setOnClickListener {
            recipePresenter.toggleFavourite()
        }
    }

    override fun showRecipeNotFoundError() {
        titleView.visibility = View.GONE
        descriptionView.text = getString(R.string.recipe_not_found)
    }

    override fun setTitle(title: String) {
        titleView.text = title
    }

    override fun setDescription(description: String) {
        descriptionView.text = description

    }

    override fun setFavourites(favourite: Boolean) {
        titleView.isSelected = favourite
    }
}