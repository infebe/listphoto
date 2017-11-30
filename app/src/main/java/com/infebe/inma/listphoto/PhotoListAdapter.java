package com.infebe.inma.listphoto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by Inma on 11/29/17.
 */

public class PhotoListAdapter extends ArrayAdapter<PhotoItem> {

    private Context context;

    public PhotoListAdapter(Context context, ArrayList<PhotoItem> items){
        super(context, 0, items);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Get the data item for this position
        PhotoItem item = getItem(position);

        //Check if an existing view is being reused, otherwise inflate the view

        if(convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_item, parent, false);
        }

        //Get the views to put data
        ImageView mImgPhoto = (ImageView) convertView.findViewById(R.id.imgPhotoListItem);
        TextView mTxtName = (TextView) convertView.findViewById(R.id.txtPhotoListItem);

        //Populate the data into the template view using the data object
        if(item != null) {
            if (mImgPhoto != null && item.getUrl() != null) {
               // mImgPhoto.setImageURI(item.getUrl());

                //Uses Glide library to insert the image in the imageView
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(android.R.drawable.ic_menu_gallery);
                requestOptions.error(android.R.drawable.ic_menu_report_image);

                Glide.with(this.context)
                        .load(item.getUrl())
                        .into(mImgPhoto);
            }
            if (mTxtName != null && item.getName() != null)
                mTxtName.setText(item.getName());
        }
        //return the completed view to render on screen
        return convertView;



    }



}
