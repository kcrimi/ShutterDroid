package com.example.kevin.shutterdroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kevin.shutterdroid.ShutterStock.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kevin on 3/7/15.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context mContext;
    private List<Image> mImages;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        public ViewHolder(View itemView){
            super(itemView);
            mImageView = (ImageView)itemView;
        }
    }

    public ImageAdapter(Context context, List<Image> images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_image,viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Image image = mImages.get(i);
        Log.d("IA", image.getLargeThumbail());
        Picasso.with(mContext).load(image.getLargeThumbail()).into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }
}
