package com.mrbell.countryprofile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewholder> {

    private Context context;
    private int[] img;
    private String []name;

    public CustomAdapter(Context context, int[] img, String[] name) {
        this.context = context;
        this.img = img;
        this.name = name;
    }

    @NonNull
    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View v =layoutInflater.inflate(R.layout.recyclerview,parent,false);
        CustomViewholder holder =new CustomViewholder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, final int position) {

        int imgid=img[position];

        holder.img.setImageResource(imgid);
        holder.tv_name.setText(name[position]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Profile_activity.class);
                intent.putExtra("pos",position);
                intent.putExtra("data",name[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class CustomViewholder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView tv_name;
        LinearLayout linearLayout;
        public CustomViewholder(View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img2);
            tv_name=itemView.findViewById(R.id.tv_name);
            linearLayout=itemView.findViewById(R.id.linearlayout);
        }
    }
}
