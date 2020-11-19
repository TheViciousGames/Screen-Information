package com.theviciousgames.screeninformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] hdrCapabsInt;
    private TextView resolutionTextView,realResolutionTextView,refreshRateTextView,HDR10TextView,HDR10PlusTextView,HDRDolbyVisionTextView,HDRHLGTextView,HDRAvailableTextView,DPITextView, DPIClassTextView,
            sizeTextView,displayModesTextView,wideColorGamutTextView,preferredWideColorGamutTextView,minimalPostProcessingTextView,displayIDTextView,displayNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareObjects();
        getInformation();

    }

    protected void declareObjects()
    {
        resolutionTextView=findViewById(R.id.resolutionSizeTextView);
        realResolutionTextView=findViewById(R.id.realResolutionTextView);
        refreshRateTextView=findViewById(R.id.refreshRateTextView);

        HDRAvailableTextView=findViewById(R.id.HDRAvailableTextView);
        HDRDolbyVisionTextView=findViewById(R.id.HDRDolbyVisionTextView);
        HDR10TextView=findViewById(R.id.HDR10TextView);
        HDR10PlusTextView=findViewById(R.id.HDR10PlusTextView);
        HDRHLGTextView=findViewById(R.id.HDRHLGTextView);

        DPITextView=findViewById(R.id.DPITextView);
        DPIClassTextView=findViewById(R.id.DPIClassTextView);

        sizeTextView=findViewById(R.id.sizeTextView);

        displayModesTextView=findViewById(R.id.displayModesTextView);

        wideColorGamutTextView=findViewById(R.id.wideColorGamutTextView);
        preferredWideColorGamutTextView=findViewById(R.id.preferredWideColorGamutTextView);

        minimalPostProcessingTextView=findViewById(R.id.minimalPostProcessingTextView);

        displayIDTextView=findViewById(R.id.displayIDTextView);

        displayNameTextView=findViewById(R.id.displayNameTextView);

    }

    protected void getInformation()
    {
        System.out.println("DIAGONAL SIZE"+Tools.getPhysicalDisplaySize(this));
        refreshRateTextView.setText(Tools.getRefreshRate(this));
        resolutionTextView.setText(Tools.getResolution(this));
        realResolutionTextView.setText(Tools.getRealResolution(this));
        DPITextView.setText(Tools.getDPI(this)+"");
        sizeTextView.setText(Tools.getPhysicalDisplaySize(this)+"'");
        displayModesTextView.setText(Tools.getSupportModes(this));
        displayIDTextView.setText(Tools.getDisplayID(this));
        displayNameTextView.setText(Tools.getDisplayName(this));
        if(Tools.getDPI(this)<121)
        {
            DPIClassTextView.setText("ldpi");
        }
        else if(Tools.getDPI(this)<121&&Tools.getDPI(this)<=159)
        {
            DPIClassTextView.setText("mdpi");
        }
        else if(Tools.getDPI(this)>159&&Tools.getDPI(this)<=239)
        {
            DPIClassTextView.setText("hdpi");
        }
        else if(Tools.getDPI(this)>239&&Tools.getDPI(this)<=319)
        {
            DPIClassTextView.setText("xhdpi");
        }else if(Tools.getDPI(this)>319&&Tools.getDPI(this)<=479)
        {
            DPIClassTextView.setText("xxhdpi");
        }else if(Tools.getDPI(this)>479)
        {
            DPIClassTextView.setText("xxxhdpi");
        }
        if(Tools.isWideColorGamut(this))
        {
            wideColorGamutTextView.setText("Yes");
            if(Tools.getPreferredWideGamutColorSpace(this)!=null)
            {
                preferredWideColorGamutTextView.setText(Tools.getPreferredWideGamutColorSpace(this));
            }
        }

        if(Build.VERSION.SDK_INT> Build.VERSION_CODES.Q)
        {
            if(Tools.isMinimalPostProcessing(this))
            {
                minimalPostProcessingTextView.setText("Yes");
            }
        }

        if(Tools.isHDR(this))
        {
            HDRAvailableTextView.setText("Yes");
        }

        hdrCapabsInt = Tools.getHDR(MainActivity.this);
        for(byte index=0;index<hdrCapabsInt.length;++index)
        {
            if(hdrCapabsInt[index]==1)
            {
                HDRDolbyVisionTextView.setText("Available");
            }
            if(hdrCapabsInt[index]==2)
            {
                HDR10TextView.setText("Available");
            }
            if(hdrCapabsInt[index]==3)
            {
                HDRHLGTextView.setText("Available");
            }
            if(hdrCapabsInt[index]==4)
            {
                HDR10PlusTextView.setText("Available");
            }
        }
    }
}