package com.example.corona_final_withapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Context context;
    List<ObjectDataClass> dataList;


    public CustomAdapter(Context context, List<ObjectDataClass> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_design,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.name.setText(dataList.get(position).getCountry());
        //holder.city.setText(dataList.get(position).getCity());
        holder.itemView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

               ObjectDataClass response= dataList.get(position);
                Intent intent=new Intent(context,DetailsActivity.class);
               intent.putExtra("response",response);
             context.startActivity(intent);
                //Toast.makeText (context, String.valueOf (dataList.get (position).getName ()), Toast.LENGTH_SHORT).show ();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name     = itemView.findViewById(R.id.name);

        }
    }
}
