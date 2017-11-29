package com.infebe.inma.listphoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //When we are in phone display, add a new ListPhotoFragment dynamically
        PhotosListFragment mPhotosFragment = new PhotosListFragment();


    }
}
