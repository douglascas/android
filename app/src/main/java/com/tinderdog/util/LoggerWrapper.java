package com.tinderdog.util;

import android.util.Log;

public class LoggerWrapper {
    private static final String APP_IDENTIFIER = "TINDDOG";

    public static void log(String msg){
        Log.d(APP_IDENTIFIER, msg);
    }
}
