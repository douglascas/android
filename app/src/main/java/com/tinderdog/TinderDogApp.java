package com.tinderdog;

import android.app.Application;
import android.content.Context;

public class TinderDogApp extends Application {

    private static TinderDogApp  instance;

    public TinderDogApp()
    {
        instance = this;
    }

    public static Context getContext()
    {
        return instance;
    }
}
