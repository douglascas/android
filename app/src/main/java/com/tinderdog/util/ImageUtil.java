package com.tinderdog.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ImageUtil {

    public static byte[] bitmapToByteArr(Bitmap img){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        img.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap byteArrToBitmap(byte[] bytes){
        return BitmapFactory.decodeByteArray(bytes , 0, bytes.length);
    }
}
