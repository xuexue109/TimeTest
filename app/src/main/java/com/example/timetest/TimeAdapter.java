package com.example.timetest;

import android.os.HardwarePropertiesManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.litepal.LitePal;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder>{
    private List<Time> timeList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView time_item;
        View timeView;
        Button time_delete;
        public ViewHolder(View view){
            super(view);
            timeView = view;
            time_item = (TextView) view.findViewById(R.id.item);
            time_delete = (Button) view.findViewById(R.id.delete);
        }
    }
    public TimeAdapter(List<Time> timeList){
        this.timeList = timeList;
    }
    @NonNull
    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        holder.time_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Time time = timeList.get(position);
                timeList.remove(position);
                LitePal.deleteAll(Time.class,"time = ?",time.getTime());
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.ViewHolder holder, int position) {
        Time time = timeList.get(position);

        holder.time_item.setText(time.getTime());
    }

    @Override
    public int getItemCount() {
        return timeList == null ? 0 : timeList.size();
    }
}
