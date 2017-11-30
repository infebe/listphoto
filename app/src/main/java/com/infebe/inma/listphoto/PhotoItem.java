package com.infebe.inma.listphoto;

import android.net.Uri;
import android.util.Log;

import org.json.JSONObject;

/**
 * Created by Inma on 11/29/17.
 */

public class PhotoItem {

    private String name;
    private Uri url;

    public static final String KEY_NAME = "title";
    public static final String KEY_URL = "thumbnailUrl";

    public PhotoItem(String name, Uri url){
        this.name = name;
        this.url = url;
    }

    public PhotoItem(JSONObject jsonPhotoItem){
        try {
            this.name = jsonPhotoItem.getString(KEY_NAME);
            this.url = Uri.parse(jsonPhotoItem.getString(KEY_URL));
        }catch(org.json.JSONException exception){
            Log.e(this.getClass().getName(), exception.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public Uri getUrl() {
        return url;
    }

    public void setUrl(Uri url) {
        this.url = url;
    }

    public void setName(String name) {

        this.name = name;
    }


}
