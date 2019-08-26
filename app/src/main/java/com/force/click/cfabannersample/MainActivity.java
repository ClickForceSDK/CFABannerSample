package com.force.click.cfabannersample;

import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clickforce.ad.AdSize;
import com.clickforce.ad.AdView;
import com.clickforce.ad.Listener.AdViewListener;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private AdView ad ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ad = (AdView) this.findViewById(R.id.ad);
        ad.getAd(8326, AdSize.MA320X50,true);
        ad.outputDebugInfo = true;
        //Ad Load Callback
        ad.setOnAdViewLoaded(new AdViewListener() {
            @Override
            public void OnAdViewLoadSuccess() {
                Log.d("Ad Response Result", "成功請求廣告");

                //顯示banner廣告
                ad.show();
            }

            @Override
            public void OnAdViewLoadFail() {
                Log.d("Ad Response Result", "請求廣告失敗");
            }

            @Override
            public void OnAdViewClickToAd() {

            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ad != null)
            ad.releaseAd();
    }
}
