package com.example.kevin.shutterdroid.ShutterStock;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kevin on 3/7/15.
 */
public class Image {
    @SerializedName("id")
    private String mId;
    
    @SerializedName("aspect")
    private Double mAspect;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("contributor")
    private User mContributor;

    @SerializedName("image_type")
    private String mImageType;

    @SerializedName("assets")
    private ImageAssets mAssets;
    
    private class ImageAssets{
        @SerializedName("preview")
        private ThumbNail mPreview;

        @SerializedName("small_thumb")
        private ThumbNail mSmallThumb;
        
        @SerializedName("large_thumb")
        private ThumbNail mLargeThumb;
    }

    public String getId() {
        return mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLargeThumbail(){
        return mAssets.mLargeThumb.mURL;
    }

    private class ThumbNail{
        @SerializedName("url")
        private String mURL;

        @SerializedName("width")
        private int width;

        @SerializedName("height")
        private int height;
    }

}
