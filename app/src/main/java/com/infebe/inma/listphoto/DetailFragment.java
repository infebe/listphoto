package com.infebe.inma.listphoto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Inma on 11/29/17.
 */

public class DetailFragment extends Fragment {

    public static final String ARG_POSITION = "position";
    private int mCurrentPosition = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //If activity recreated such as screen rotate, restore
        //the previous photo selection set by onSaveInstanceState()
        if(savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.photo_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //During startup, check if there are arguments passed to the fragment.
        //onStart is a good place because the layout has already been applied to the
        //fragment at this point, so we can safely call the method that sets the details text

        Bundle args = getArguments();
        if(args!=null){
            //Set PhotoItem based on the argument passed in
            updatePhotoDetail(args.getInt(ARG_POSITION));
        }else if(mCurrentPosition != -1){
            //Set the PhotoItem based on the saved instance state defined in onCreateView
            updatePhotoDetail(mCurrentPosition);
        }
    }

    public void updatePhotoDetail(int position){

        ImageView imgView = (ImageView) getActivity().findViewById(R.id.imgPhoto);
        TextView txtPhoto = (TextView) getActivity().findViewById(R.id.txtPhotoName);

        //TODO: temp solution, Think of a better one to share the data

        ArrayList<PhotoItem> photoList = PhotosListFragment.getPhotoListData();

        imgView.setImageURI(photoList.get(position).getUrl());
        txtPhoto.setText(photoList.get(position).getName());

        mCurrentPosition = position;
    }
}
