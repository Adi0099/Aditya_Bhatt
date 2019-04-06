package com.aditya_bhatt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.aditya_bhatt.utills.SessionManager;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

public class Photo_Details extends AppCompatActivity {
    int imagePosition;
    String stringImageUri;
    SimpleDraweeView mImageView;
    TextView name,designation,qualification,sub;
    String pref_image,pref_name,pref_designation,pref_qualification,pref_sub;

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo__details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mImageView = findViewById(R.id.image);
        name = findViewById(R.id.name);

        //get leave-list item
        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> staff = sessionManager.getImage();
        pref_image = staff.get(SessionManager.IMAGE);
        pref_name = staff.get(SessionManager.TITLE);


        Log.d("details",pref_image+" "+pref_name);
        //Getting image uri from previous screen

        Uri uri = Uri.parse(pref_image);
        mImageView.setImageURI(uri);
        name.setText(pref_name);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(Photo_Details.this, PhotoList.class);
                startActivity(intent);
                finish();
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Photo_Details.this, PhotoList.class);
        startActivity(intent);
        finish();

    }
}
