package com.theviciousgames.screeninformation;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;

import java.util.ArrayList;

public class Tools {
    public static int getDPI(Activity activity)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }
    public static String getResolution(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height= displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return height+"x"+width;
    }
    public static String getRefreshRate(Activity activity)
    {
        return activity.getWindowManager().getDefaultDisplay().getRefreshRate() + "";
    }
    public static int[] getHDR(Activity activity)
    {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Display.HdrCapabilities hdrCapabilities = display.getHdrCapabilities();
        int[] hdrTypes=hdrCapabilities.getSupportedHdrTypes();
        return hdrTypes;
    }

    public static String getRealResolution(Activity activity)
    {
        Point size = new Point();
        Display display = activity.getWindowManager().getDefaultDisplay();
        display.getRealSize(size);

        int realWidth = size.x;
        int realHeight = size.y;

        return realHeight+"x"+realWidth;
    }

    public static Boolean isHDR(Activity activity)
    {
        return activity.getWindowManager().getDefaultDisplay().isHdr();
    }

    public static String getPhysicalDisplaySize(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels/dm.xdpi,2);
        double y = Math.pow(dm.heightPixels/dm.ydpi,2);
        double screenInches=Math.sqrt(x+y);
        String screenSize=screenInches+"";
        double finalSize=Double.parseDouble(screenSize.charAt(0)+"."+screenSize.charAt(screenSize.indexOf('.')+1));
        return finalSize+"";
    }
    public static String getSupportModes(Activity activity)
    {
        String finalString=new String();
        Display.Mode[] modesList=activity.getWindowManager().getDefaultDisplay().getSupportedModes();
        for(Display.Mode index: modesList)
        {
            finalString=finalString+"\n"+index;
        }
        return finalString;
    }

    public static Boolean isWideColorGamut(Activity activity)
    {
        return activity.getWindowManager().getDefaultDisplay().isWideColorGamut();
    }
    public static String getPreferredWideGamutColorSpace(Activity activity)
    {
        return activity.getDisplay().getPreferredWideGamutColorSpace()+"";
    }

    public static Boolean isMinimalPostProcessing(Activity activity)
    {
        return activity.getDisplay().isMinimalPostProcessingSupported();
    }

    public static String getDisplayID(Activity activity)
    {
        return activity.getDisplay().getDisplayId()+"";
    }

    public static String getDisplayName(Activity activity)
    {
        return activity.getDisplay().getName();
    }







}
