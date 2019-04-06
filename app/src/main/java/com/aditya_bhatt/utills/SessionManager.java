package com.aditya_bhatt.utills;

/**
 * Created by user on 3/16/2018.
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;
import java.util.jar.Attributes;

public class SessionManager {


    // Shared Preferences
    private SharedPreferences pref;

    // Editor for Shared preferences
    private Editor editor;

    // Context
    private Context _context;

    // Shared pref mode
    private int PRIVATE_MODE = 0;


    // Sharedpref file name
    private static final String PREF_NAME = "adi";



    public static final String ALBUMID = "albumId";

    public static final String IMAGE= "image";
    public static final String TITLE = "title";




    // Constructor
    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();


    }

    //save token
    public  void saveAlbumId(String albumId){
        editor.putString(ALBUMID,albumId);
        editor.commit();
    }
    /**
     * Get stored session data
     * */
    public HashMap<String, String> getAlbumId(){
        HashMap<String, String> album = new HashMap<String, String>();
        album.put(ALBUMID, pref.getString(ALBUMID, null));


        // return id
        return album;
    }

    //save token
    public  void saveImage(String image,String name){
        editor.putString(IMAGE,image);
        editor.putString(TITLE,name);

        editor.commit();
    }
    /**
     * Get stored session data
     * */
    public HashMap<String, String> getImage(){
        HashMap<String, String> image = new HashMap<String, String>();
        image.put(IMAGE, pref.getString(IMAGE, null));
        image.put(TITLE, pref.getString(TITLE, null));

        // return id
        return image;
    }
}
