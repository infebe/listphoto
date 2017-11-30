package com.infebe.inma.listphoto;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Inma on 11/30/17.
 */

public class GetPhotoListDataVolley {

    static private ArrayList<PhotoItem> photoListData;
    private String URL_ADDRESS = "https://jsonplaceholder.typicode.com/photos";
    onDataReceivedListener mCallback;


    public interface onDataReceivedListener{
        public void receivedData();
    }

    public GetPhotoListDataVolley(final PhotosListFragment context){
        super();

        mCallback = (onDataReceivedListener) context;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_ADDRESS,
                new Response.Listener<JSONArray>(){
                    public void onResponse(JSONArray response){
                        if(response != null){
                            photoListData = new ArrayList<PhotoItem>();
                            //TODO: at the time I am going to read only the 20 first
                            for(int i = 0; i < 20; i++){
                                try {
                                    photoListData.add(new PhotoItem(response.getJSONObject(i)));
                                }catch(org.json.JSONException exception){
                                    Log.e(this.getClass().getName(), exception.getMessage());
                                }
                            }
                        }

                        mCallback.receivedData();

                    }


                },
                new Response.ErrorListener(){
                    public void onErrorResponse(VolleyError error){
                        //TODO: do something, error.getMessage()
                        Toast.makeText(context.getContext(), R.string.error_getting_array, Toast.LENGTH_SHORT ).show();
                    }
                }
        );

        MySingleton.getInstance(context.getContext()).addToRequestQueue(jsonArrayRequest);
    }


    public static ArrayList<PhotoItem> getDataList(){
        return photoListData;
    }




}
