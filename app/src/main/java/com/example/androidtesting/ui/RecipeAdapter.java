package com.example.androidtesting.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtesting.R;
import com.example.androidtesting.data.local.RecipeStore;
import com.example.androidtesting.data.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final RecipeStore recipeStore;

    public RecipeAdapter(RecipeStore recipeStore) {
        this.recipeStore = recipeStore;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        final Recipe recipe = recipeStore.recipes.get(position);
        holder.textView.setText(recipe.getTitle());
        holder.textView.setOnClickListener(v -> {
            Context context = holder.textView.getContext();
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra(RecipeActivity.KEY_ID, recipe.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recipeStore.recipes.size();
    }
}
