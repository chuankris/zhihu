package com.zhihu.chuankris.myapplication.preferrence;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by qiuxuechuan on 2016/2/3.
 */
public class GlobalContext extends Application {

    private Application application;
    //singleton
    private static GlobalContext globalContext = null;

    private static Context mContext;
    //image size
    private Activity activity = null;
    private Activity currentRunningActivity = null;
    private DisplayMetrics displayMetrics = null;


    //current account info

    public boolean startedApp = false;


    public static final String CACHE_RELATIVE_PATH = "capture/";


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        globalContext = this;
        mContext = getApplicationContext();

    }


    public static GlobalContext getInstance() {
        return globalContext;
    }

    public static Context getContext() {
        return mContext;
    }

    public DisplayMetrics getDisplayMetrics() {
        if (displayMetrics != null) {
            return displayMetrics;
        } else {
            Activity a = getActivity();
            if (a != null) {
                Display display = getActivity().getWindowManager().getDefaultDisplay();
                DisplayMetrics metrics = new DisplayMetrics();
                display.getMetrics(metrics);
                this.displayMetrics = metrics;
                return metrics;
            } else {
                //default screen is 800x480
                DisplayMetrics metrics = new DisplayMetrics();
                metrics.widthPixels = 480;
                metrics.heightPixels = 800;
                return metrics;
            }
        }
    }

    public void screenLightDown() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 0.7f;
        getCurrentRunningActivity().getWindow().setAttributes(lp);
    }

    public void screenLightUp() {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = 1f;
        getCurrentRunningActivity().getWindow().setAttributes(lp);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getCurrentRunningActivity() {
        return currentRunningActivity;
    }

    public void setCurrentRunningActivity(Activity currentRunningActivity) {
        this.currentRunningActivity = currentRunningActivity;
    }


    public static int getVersionCode() {
        PackageInfo packInfo = null;
        try {
            packInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
        }

        return packInfo != null ? packInfo.versionCode : 1;
    }


    public static String getPackageNameStatic() {
        PackageInfo packInfo = null;
        try {
            packInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
        }

        return packInfo != null ? packInfo.packageName : "com.hik.hikvision.canyin";
    }

    public static String getVersionName() {
        PackageInfo packInfo = null;
        try {
            packInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
        }

        return packInfo != null ? packInfo.versionName : "1.0.0";
    }
}


