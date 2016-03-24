package com.orcaphin.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;


import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity
{   Button  mBtnAdd;
    Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnAdd= (Button) findViewById(R.id.btn_add);
        mtoolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
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
