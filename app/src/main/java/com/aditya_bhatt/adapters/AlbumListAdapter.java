package com.aditya_bhatt.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aditya_bhatt.R;
import com.aditya_bhatt.models.AlbumListModel;


import java.util.List;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.MyViewHolder> {

    private List<AlbumListModel> albumListModels;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);

        }
    }
    public AlbumListAdapter(List<AlbumListModel> albumListAdapterList) {
        this.albumListModels = albumListAdapterList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AlbumListModel albumListModel = albumListModels.get(position);
        holder.title.setText("Album : " + albumListModel.getAlbumId());

    }

    @Override
    public int getItemCount() {
        return albumListModels.size();
    }
}