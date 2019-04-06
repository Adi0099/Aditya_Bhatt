package com.aditya_bhatt;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.aditya_bhatt.adapters.PhotoListAdapter;
import com.aditya_bhatt.models.AlbumListModel;
import com.aditya_bhatt.utills.RecyclerTouchListener;
import com.aditya_bhatt.utills.SessionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhotoList extends AppCompatActivity {

    RecyclerView recyclerView;
    static protected List<AlbumListModel> photList = new ArrayList<>();
    static protected PhotoListAdapter mAdapter;
    StaggeredGridLayoutManager layoutManager;
    SessionManager sessionManager;
    String image,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        recyclerView = findViewById(R.id.recycler_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sessionManager = new SessionManager(this);
        HashMap<String, String> savedAlbumId = sessionManager.getAlbumId();
        final String id = savedAlbumId.get(SessionManager.ALBUMID);

        Log.d("photolist",id);

        if(getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        }
        else {
            layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        }

        mAdapter = new PhotoListAdapter(photList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        PhotoListWebService.photoListWebService(this,id);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                AlbumListModel albumListModel = photList.get(position);
                image = albumListModel.getUrl();
                name = albumListModel.getTitle();

                Log.d("photoList",image+name);
                sessionManager = new SessionManager(getApplicationContext());
                sessionManager.saveImage(image,name);
                Intent intent = new Intent(PhotoList.this,Photo_Details.class);
                startActivity(intent);
                finish();



            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(PhotoList.this, AlbumList.class);
                startActivity(intent);
                finish();
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(PhotoList.this, AlbumList.class);
        startActivity(intent);
        finish();

    }
}
