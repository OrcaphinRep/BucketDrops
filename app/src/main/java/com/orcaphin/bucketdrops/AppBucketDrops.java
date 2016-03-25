package com.orcaphin.bucketdrops;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Vineet on 25-03-2016.
 */
public class AppBucketDrops extends Application //Register this file in the Manifest. VERY IMPORTANT//
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        RealmConfiguration configuration=new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(configuration);
    }
}
