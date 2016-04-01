package com.orcaphin.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orcaphin.bucketdrops.R;
import com.orcaphin.bucketdrops.beans.Drop;

import io.realm.RealmResults;

public class AdapterDrops extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final int ITEM = 0;
    public static final int FOOTER = 1;
    private LayoutInflater mInflater;
    RealmResults<Drop> mResults;

    public AdapterDrops(Context context, RealmResults<Drop> results)
    {
        mInflater = LayoutInflater.from(context);
        mResults = results;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (viewType == FOOTER)

        {
            View v = mInflater.inflate(R.layout.footer, parent, false);
            return new FootHolder(v);
        }

        else
        {
            View v = mInflater.inflate(R.layout.row_drop, parent, false);
            return new DropHolder(v);
        }

    }
    @Override
    public int getItemViewType(int position)
    {
        if (mResults == null || position < mResults.size()) {
            return ITEM;
        } else
            return FOOTER;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof DropHolder) {
            DropHolder dropHolder = (DropHolder) holder;
            Drop Drop = mResults.get(position);
            dropHolder.mWhat.setText(Drop.getWhat());
        }
    }

    @Override
    public int getItemCount()
    {
        return mResults.size()+1;
    }


    public static class DropHolder extends RecyclerView.ViewHolder
    {
        TextView mWhat;

        public DropHolder(View itemView)
        {
            super(itemView);
            mWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }

    public static class FootHolder extends RecyclerView.ViewHolder
    {
        Button mBtnAdd;

        public FootHolder(View itemView)
        {
            super(itemView);
            mBtnAdd = (Button) itemView.findViewById(R.id.btn_footer);
        }
    }


    public void update(RealmResults<Drop> Results)
    {
        mResults = Results;
        notifyDataSetChanged(); //Notifies when the data has been changed to the adapter//
    }
}
