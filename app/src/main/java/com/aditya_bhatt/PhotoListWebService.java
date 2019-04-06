package com.aditya_bhatt;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.aditya_bhatt.models.AlbumListModel;
import com.aditya_bhatt.utills.Constants;
import com.aditya_bhatt.utills.MyApplication;
import com.aditya_bhatt.utills.ProgressBar;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aditya on 6/17/2018.
 */

public class PhotoListWebService {

    public static  void photoListWebService(final Activity activity, final String id) {
        // Progress dialog
        PhotoList.photList.clear();
        final ProgressDialog progressDialog;

        progressDialog = ProgressBar.showProgressDialog(activity,  activity.getResources().getString(R.string.pswait));


        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.PHOTOlIST+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Log.d("url",Constants.PHOTOlIST+id);
//                swipeView.setRefreshing(false);
                try {

                    //getting the whole json object from the response
//                    JSONObject obj = new JSONObject(response);
                    Log.d("response",response);

                    JSONArray jsonArray = new JSONArray(response);
                    //now looping through all the elements of the json array
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            AlbumListModel albumListModel = new AlbumListModel();

                            albumListModel.setAlbumId(String.valueOf(jsonObject1.get("albumId")));
                            albumListModel.setId(String.valueOf(jsonObject1.getInt("id")));
                            albumListModel.setTitle(jsonObject1.getString("title"));
                            albumListModel.setUrl(jsonObject1.getString("url"));
                            albumListModel.setThumbnail(jsonObject1.getString("thumbnailUrl"));

                            PhotoList.photList.add(albumListModel);
                            PhotoList.mAdapter.notifyDataSetChanged();
                        }




                } catch (JSONException e1) {
                    e1.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast toast = Toast.makeText(activity,
                        activity.getResources().getString(R.string.tryagain),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
//        AppController.getInstance().addToRequestQueue(stringRequest);
        MyApplication.getInstance().addToRequestQueue(stringRequest);

    }
}
