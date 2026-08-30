package com.avl.cagApp.libs;
import android.content.Context;
import android.provider.Settings;


public class MyLibUtil {

    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}
