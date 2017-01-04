package com.astu360.test5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by astu on 1/4/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.list_layout,parent,false);
        return new MyAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.textHead.setText(listItem.getHead());
        holder.textDesc.setText(listItem.getDesc());
        Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textHead;
        TextView textDesc;
        ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            textHead = (TextView) itemView.findViewById(R.id.headView);
            textDesc = (TextView) itemView.findViewById(R.id.descView);
            imageView = (ImageView) itemView.findViewById(R.id.imgVw);
        }
    }
}
