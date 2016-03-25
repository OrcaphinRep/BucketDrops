package com.orcaphin.bucketdrops.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orcaphin.bucketdrops.R;
import com.orcaphin.bucketdrops.beans.Drop;

import io.realm.RealmResults;

public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder>
{
    private LayoutInflater mInflater;
    RealmResults<Drop> mResults;

    public AdapterDrops(Context context,RealmResults<Drop> results)
    {
        mInflater=LayoutInflater.from(context);
        mResults=results;
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

            View v=mInflater.inflate(R.layout.row_drop,parent,false);
            DropHolder holder=new DropHolder(v);
            return holder;
    }

    public void update(RealmResults<Drop> Results)
    {
        mResults=Results;
        notifyDataSetChanged(); //Notifies when the data has been changed to the adapter//
    }
    @Override
    public void onBindViewHolder(DropHolder holder, int position)
    {
        Drop drop=mResults.get(position);
        holder.mWhat.setText(drop.getWhat());

    }

    @Override
    public int getItemCount()
    {
        return mResults.size();
    }


    public static class DropHolder extends RecyclerView.ViewHolder
    {
        TextView mWhat;
        public DropHolder(View itemView)
        {
            super(itemView);
            mWhat= (TextView) itemView.findViewById(R.id.tv_what);
        }
    }
}
