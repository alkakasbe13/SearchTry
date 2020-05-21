package com.example.searchtry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Users> users;
    private Context context;

    public Adapter(List<Users> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public  MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
holder.location.setText(users.get(position).getLocaiton());
holder.caption.setText(users.get(position).getCaption());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView location,caption;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            location=itemView.findViewById(R.id.textView);
            caption=itemView.findViewById(R.id.textView1);
        }
    }
}
