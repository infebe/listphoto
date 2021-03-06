package com.infebe.inma.listphoto;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Inma on 11/29/17.
 */

public class PhotosListFragment extends ListFragment implements GetPhotoListDataVolley.onDataReceivedListener {

    OnPhotoSelectedListener mCallback;
    Context mContext;

    @Override
    public void receivedData() {
        //When we have the data, we show it

        //Create adapter for the ListFragment
        //getActivity returns the Activity associated to a Fragment
        PhotoListAdapter mPhotoListAdapter = new PhotoListAdapter(getActivity(), GetPhotoListDataVolley.getDataList());

        //Set the list adapter for this ListFragment
        setListAdapter(mPhotoListAdapter);
    }

    //Fragments can't communicate directly. They have to do it
    //through the Activity where they are contained
    //The container Activity has to implement this interface
    //TWO FRAGMENTS SHOULD NEVER COMMUNICATE DIRECTLY
    public interface OnPhotoSelectedListener{
        public void onPhotoSelected(int position);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //First of all, retrieve the list data
        getPhotoListDataJSONVolley(this);

      /* This is the solution for when we have Local data
       *
       //Create adapter for the ListFragment
        //getActivity returns the Activity associated to a Fragment
        PhotoListAdapter mPhotoListAdapter = new PhotoListAdapter(getActivity(), getPhotoListDataJSONVolley(mContext));

        //Set the list adapter for this ListFragment
        setListAdapter(mPhotoListAdapter);*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Make sure that the container activity has implemented the
        //callback interface. If not, throw exception.
        //This is necessary so that MainActivity knows that the item is selected
        //and opens the detail view.

        try{
            mCallback = (OnPhotoSelectedListener) context;
            mContext = context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement OnPhotoSelecetedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.onPhotoSelected(position);
    }

    public static ArrayList<PhotoItem> getPhotoListData(){

        ArrayList<PhotoItem> listPhotos = new ArrayList<PhotoItem>();

        //For now, we will generate the data here, but the idea is to get it from
        //a JSON restful service

        PhotoItem photoItem1 = new PhotoItem("Photo 1",  Uri.parse("http://placehold.it/150/92c952"));
        PhotoItem photoItem2 = new PhotoItem("Photo 2", Uri.parse("http://placehold.it/150/771796"));

        listPhotos.add(photoItem1);
        listPhotos.add(photoItem2);

        return listPhotos;
    }



    public ArrayList<PhotoItem> getPhotoListDataJSONVolley(PhotosListFragment context){
        GetPhotoListDataVolley getData = new GetPhotoListDataVolley(context);
        return getData.getDataList();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //When using two-pane layout, configure the ListView to highlight the selected item
        if(this.getFragmentManager().findFragmentById(R.id.detail_fragment)!=null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }
}
