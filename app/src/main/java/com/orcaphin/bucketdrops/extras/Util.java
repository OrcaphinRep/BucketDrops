package com.orcaphin.bucketdrops.extras;

import android.view.View;

import java.util.List;

/**
 * Created by Vineet on 25-03-2016.
 */
public class Util
{
    public static void showViews(List<View> views)
    {
        for(View view:views)
        {
           view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views)
    {
        for(View view:views)
        {
            view.setVisibility(View.GONE);
        }
    }
}
