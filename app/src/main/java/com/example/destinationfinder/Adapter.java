package com.example.destinationfinder;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<resturant> resturants;

    public Adapter(Context context, List<resturant> resturants) {
        this.context = context;
        this.resturants = resturants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.resturants, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(resturants.get(position).getTitle());
        holder.imageView.setImageResource(resturants.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return resturants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            title = (TextView) itemView.findViewById(R.id.heading_text);
            imageView = (ImageView) itemView.findViewById(R.id.book_img);

        }
    }
}