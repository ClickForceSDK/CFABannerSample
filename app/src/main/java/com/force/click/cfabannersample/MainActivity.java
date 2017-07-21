package com.force.click.cfabannersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clickforce.ad.AdView;
import com.clickforce.ad.Listener.AdViewLinstener;

public class MainActivity extends AppCompatActivity {

    private AdView ad ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ad = (AdView) this.findViewById(R.id.ad);
        int weg = (int) ((this.getResources().getDisplayMetrics().widthPixels) * 0.6);
        int hig = (int) (weg * 0.15625);
        ad.getAd(3783, weg, hig,320,50);


        //Ad Load Callback
        ad.setOnAdViewLoaded(new AdViewLinstener() {
            @Override
            public void setOnAdViewLoadFailResult() {
                Log.d("Ad Response Result", "請求廣告失敗");
            }
            @Override
            public void setOnAdViewLoadSuccessResult() {
                Log.d("Ad Response Result", "成功請求廣告");
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
