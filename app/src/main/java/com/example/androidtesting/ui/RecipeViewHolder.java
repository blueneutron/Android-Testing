package com.example.androidtesting.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public final TextView textView;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView)itemView;
    }
}
