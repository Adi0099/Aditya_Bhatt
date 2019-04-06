package com.aditya_bhatt.adapters;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aditya_bhatt.R;
import com.aditya_bhatt.models.AlbumListModel;
import com.aditya_bhatt.utills.SessionManager;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.MyViewHolder> {

    private List<AlbumListModel> albumListModels;
    public SessionManager sessionManager;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,title;
        final SimpleDraweeView mImageView;
        LinearLayout linearLayout;

        MyViewHolder(View view) {
            super(view);
            linearLayout = view.findViewById(R.id.layout_item);
            mImageView = view.findViewById(R.id.image1);
            id = view.findViewById(R.id.id);
            title = view.findViewById(R.id.title);

            }
    }
    public PhotoListAdapter(List<AlbumListModel> albumListModelList) {
        this.albumListModels = albumListModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

            return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final AlbumListModel albumListModel = albumListModels.get(position);
        holder.mImageView.setImageURI(Uri.parse(albumListModel.getThumbnail()));
        holder.id.setText(albumListModel.getId());
        holder.title.setText(albumListModel.getTitle());



        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Activity activity = (Activity) v.getContext();
//                sessionManager = new SessionManager(activity);
//                String id = studentlistModel.getId();
//                String name = studentlistModel.getName();
//                String stu_class = studentlistModel.getStu_class();
//                String section = studentlistModel.getSection();
//                String image = studentlistModel.getImage();
//
//                sessionManager.saveLoggedChild(id,name,stu_class,section,image);

            }
        });
    }

    @Override
    public int getItemCount() {
        return albumListModels.size();
    }
}