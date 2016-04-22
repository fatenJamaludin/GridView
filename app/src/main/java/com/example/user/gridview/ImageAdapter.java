package com.example.user.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by User on 4/21/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private int lastPosition = -1;
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    static class ViewHolder {
        @InjectView(R.id.expanded_image) ImageView expanded_image;
        @InjectView(R.id.expanded_text) TextView expanded_text;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_content, parent, false);
            vh = new ViewHolder();
            ButterKnife.inject(vh, convertView);
            convertView.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.expanded_text.setText("Online");
        vh.expanded_image.setImageResource(mThumbIds[position]);

        Animation animation = AnimationUtils.loadAnimation(convertView.getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        vh.expanded_image.startAnimation(animation);
        lastPosition = position;

        return convertView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.image_1, R.drawable.image_2,
            R.drawable.image_3, R.drawable.image_4,
            R.drawable.image_5, R.drawable.image_6,
            R.drawable.image_7, R.drawable.image_8,
            R.drawable.image_9, R.drawable.image_10,
            R.drawable.image_11, R.drawable.image_12,
            R.drawable.image_1, R.drawable.image_2,
            R.drawable.image_3, R.drawable.image_4,
            R.drawable.image_5, R.drawable.image_6,
            R.drawable.image_7, R.drawable.image_8,
            R.drawable.image_9, R.drawable.image_10,
            R.drawable.image_11, R.drawable.image_12
    };
}