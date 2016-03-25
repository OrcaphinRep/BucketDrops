package com.orcaphin.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;


import com.bumptech.glide.Glide;
import com.orcaphin.bucketdrops.adapters.AdapterDrops;
import com.orcaphin.bucketdrops.beans.Drop;
import com.orcaphin.bucketdrops.widgets.BucketRecyclerView;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ActivityMain extends AppCompatActivity
{   Button  mBtnAdd;
    Toolbar mtoolbar;
    BucketRecyclerView mRecycler;
    Realm mRealm;
    View mEmptyView;
    RealmResults<Drop> mResults;
    AdapterDrops mAdapter;
    @Override
    protected void onStart()
    {
        super.onStart();
        mResults.addChangeListener(mChangeListener);

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        mResults.removeChangeListener(mChangeListener);
    }

    private RealmChangeListener mChangeListener=new RealmChangeListener()
    {
        @Override
        public void onChange()
        {
            mAdapter.update(mResults);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAdd= (Button) findViewById(R.id.btn_add);
        mtoolbar= (Toolbar) findViewById(R.id.toolbar);
        mEmptyView=findViewById(R.id.empty_drops);
        setSupportActionBar(mtoolbar);
        mRecycler= (BucketRecyclerView) findViewById(R.id.rv_drop);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecycler.setLayoutManager(manager);
        mRealm=Realm.getDefaultInstance();
        mResults=mRealm.where(Drop.class).findAllAsync();
        mAdapter=new AdapterDrops(this,mResults);
        mRecycler.hideIfEmpty(mtoolbar);
        mRecycler.showIfEmpty(mEmptyView);
        mRecycler.setAdapter(mAdapter);
        initBackgroundImage();
        mBtnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showDialogAdd();
            }
        });
    }

    private void showDialogAdd()
    {
        DialogAdd dialog=new DialogAdd();
        dialog.show(getSupportFragmentManager(),"Bucket Drops Add");
    }

    private void initBackgroundImage()
    {
        ImageView background= (ImageView) findViewById(R.id.iv_background);
        Glide.with(this).load(R.drawable.background).centerCrop().into(background);
    }
}
