package com.infebe.inma.listphoto;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Inma on 11/29/17.
 */

public class PhotosListFragment extends ListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create adapter for the ListFragment
        //getActivity returns the Activity associated to a Fragment
        PhotoListAdapter mPhotoListAdapter = new PhotoListAdapter(getActivity(), getPhotoListData());

        //Set the list adapter for this ListFragment
        setListAdapter(mPhotoListAdapter);
    }



    private ArrayList<PhotoItem> getPhotoListData(){

        ArrayList<PhotoItem> listPhotos = new ArrayList<PhotoItem>();

        //For now, we will generate the data here, but the idea is to get it from
        //a JSON restful service

        PhotoItem photoItem1 = new PhotoItem("Photo 1",  Uri.parse("http://placehold.it/150/92c952"));
        PhotoItem photoItem2 = new PhotoItem("Photo 2", Uri.parse("http://placehold.it/150/771796"));

        listPhotos.add(photoItem1);
        listPhotos.add(photoItem2);

        return listPhotos;
    }


}
