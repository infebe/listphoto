package com.infebe.inma.listphoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements PhotosListFragment.OnPhotoSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check that the activity is using the layout version with
        //the fragment_container FrameLayout
        //When this exists, we will be in phone display
        if(findViewById(R.id.fragment_container)!=null){

            //If we are being restored from a previous state,
            //then we don't need to do anything and should return or else
            //we could end up with overlapping fragments
            if(savedInstanceState != null){
                return;
            }

            //Create a new Fragment to be placed in the activity layout
            PhotosListFragment mPhotosFragment = new PhotosListFragment();

            //Add fragment to the  'fragment_container' FrameLayout. We are dynamically inserting the fragment
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mPhotosFragment).commit();
        }




    }

    @Override
    public void onPhotoSelected(int position) {
        Log.i(this.getClass().getName(), "Entered onPhotoSelected. The photo selected was " + position);

       //We have to display the details of the selected Photo

    }
}
