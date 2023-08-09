package com.example.wallpapre;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallpapre.Activthy.Setwallpaper;
import com.example.wallpapre.Modles.ImageModel;

import java.lang.reflect.Array;
import java.time.temporal.Temporal;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    Context context;
    ArrayList<ImageModel> wallpaperlist;

    public Adapter(Context context, ArrayList<ImageModel> wallpaperlist) {
        this.context = context;
        this.wallpaperlist = wallpaperlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view)
                ;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setOnClickListener(v -> {
            holder.textView.setMovementMethod(LinkMovementMethod.getInstance());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browswerintent = new Intent(Intent.ACTION_VIEW);
                    browswerintent.setData(Uri.parse("https://www.pexels.com/"));
                    browswerintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(browswerintent);
                }
            });


        });

        Glide.with(context).load(wallpaperlist.get(position).getSrc().getPortrait()).into(holder.imageView);
        holder.imageView.setOnClickListener(v ->{
            Intent intent = new Intent(context, Setwallpaper.class);
            intent.putExtra("image",wallpaperlist.get(position).getSrc().getPortrait());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return wallpaperlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
