package com.cv4j.transformations;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.cv4j.core.datamodel.CV4JImage;
import com.cv4j.core.filters.CommonFilter;

/**
 * Created by Tony Shen on 2017/7/16.
 */

public class CV4JForGlideTransformation extends BitmapTransformation {

    private CommonFilter filter;

    public CV4JForGlideTransformation(Context context, CommonFilter filter) {
        super(context);
        this.filter = filter;
    }

    @Override
    protected Bitmap transform(BitmapPool bitmapPool, Bitmap original, int width, int height) {
        Bitmap result = null;

        CV4JImage colorImage = new CV4JImage(original);

        if (filter!=null)
            result = filter.filter(colorImage.getProcessor()).getImage().toBitmap();

        return result;
    }

    @Override
    public String getId() {
        return "cn.magicwindow.toutiao.utils.CV4JForGlideTransformation";
    }
}
