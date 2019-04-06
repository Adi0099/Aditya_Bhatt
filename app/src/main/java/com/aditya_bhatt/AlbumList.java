package com.aditya_bhatt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.aditya_bhatt.adapters.AlbumListAdapter;
import com.aditya_bhatt.models.AlbumListModel;
import com.aditya_bhatt.utills.RecyclerTouchListener;
import com.aditya_bhatt.utills.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class AlbumList extends AppCompatActivity {

    public static List<AlbumListModel> albumListModels = new ArrayList<>();
    public  RecyclerView recyclerView;
    protected static AlbumListAdapter mAdapter;
    SessionManager sessionManager;

    String albumId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mAdapter = new AlbumListAdapter(albumListModels);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        AlbumListWebService.albumListWebService(this);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                AlbumListModel albumListModel = AlbumList.albumListModels.get(position);
                albumId = albumListModel.getAlbumId();

                Log.d("sss",albumId);
                sessionManager = new SessionManager(getApplicationContext());
                sessionManager.saveAlbumId(albumId);
                Intent intent = new Intent(AlbumList.this,PhotoList.class);
                startActivity(intent);
                finish();



            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

}
