package com.orcaphin.bucketdrops.widgets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.orcaphin.bucketdrops.extras.Util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vineet on 25-03-2016.
 */
public class BucketRecyclerView extends RecyclerView
{   private List<View> mNonEmptyViews= Collections.emptyList();
    private List<View> mEmptyViews=Collections.emptyList();
    AdapterDataObserver mObserver = new AdapterDataObserver()
    {
        @Override
        public void onChanged()
        {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount)
        {
            toggleViews();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload)
        {
            toggleViews();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount)
        {
            toggleViews();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount)
        {
            toggleViews();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)
        {
            toggleViews();
        }
    };

    private void toggleViews()
    {
        if(getAdapter()!=null && !mEmptyViews.isEmpty()&& !mNonEmptyViews.isEmpty())
        {
            if(getAdapter().getItemCount()==0)
            {
                // show all views meant to be shown
                Util.showViews(mEmptyViews);

                //hide recyclerview
                setVisibility(View.GONE);

                //hide all views which are meant to be hidden
             Util.hideViews(mNonEmptyViews);

            }
            else
            {
                // hide all views meant to be hidden
                Util.hideViews(mEmptyViews);

                //show recyclerview
                setVisibility(View.VISIBLE);

                //show all views which are meant to be shown
                Util.showViews(mNonEmptyViews);

            }
        }
    }

    public BucketRecyclerView(Context context)
    {
        super(context);
    }

    public BucketRecyclerView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public BucketRecyclerView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }


    @Override
    public void setAdapter(Adapter adapter)
    {
        super.setAdapter(adapter);
         if(adapter!=null)
         {
             adapter.registerAdapterDataObserver(mObserver);
         }
        mObserver.onChanged();
    }

    public void hideIfEmpty(View ...views)
    {
        mNonEmptyViews= Arrays.asList(views);
    }

    public void showIfEmpty(View ...emptyViews)
    {
        mEmptyViews=Arrays.asList(emptyViews);
    }
}
