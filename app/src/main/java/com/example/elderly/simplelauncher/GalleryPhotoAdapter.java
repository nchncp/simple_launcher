package com.example.elderly.simplelauncher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by nicha on 9/27/16.
 */

public class GalleryPhotoAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mUrls;
    private LayoutInflater mInflater;

    public GalleryPhotoAdapter(Context context, String[] urls) {
        mContext = context;
        mUrls = urls;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return mUrls.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.gallery_item, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.imageView = (ImageView)
                    convertView.findViewById(R.id.grid_item);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(mContext).load(mUrls[position]).into(viewHolder.imageView);
        return convertView;
    }

    public class ViewHolder {
        ImageView imageView;
    }

}

