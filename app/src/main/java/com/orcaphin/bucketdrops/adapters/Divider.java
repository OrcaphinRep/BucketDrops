package com.orcaphin.bucketdrops.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

import com.orcaphin.bucketdrops.R;

/**
 * Created by Vineet on 03-04-2016.
 */
public class Divider extends RecyclerView.ItemDecoration
{
    private Drawable mDivider;
    private int mOrientation;

    public Divider(Context context,int orientation)
    {
       mDivider= ContextCompat.getDrawable(context,R.drawable.divider);
    }
}
