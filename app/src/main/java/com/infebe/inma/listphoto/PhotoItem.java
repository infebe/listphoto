package com.infebe.inma.listphoto;

import android.net.Uri;

/**
 * Created by Inma on 11/29/17.
 */

public class PhotoItem {

    private String name;
    private Uri url;

    public PhotoItem(String name, Uri url){
        this.name = name;
        this.url = url;
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
