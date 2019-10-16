package com.example.destinationfinder;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] items;

    public Adapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.activity_signup, parent, false);
        Item item = new Item(row);

        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Item) holder).editText.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class Item extends RecyclerView.ViewHolder {
        EditText editText;

        public Item(@NonNull View itemView) {

            super(itemView);
            editText = (EditText) itemView.findViewById(R.id.email);
        }
    }
}