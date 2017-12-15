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
        ad.getAd(3783,320,50,1,30);
        ad.outputDebugInfo = true;


        //Ad Load Callback
        ad.setOnAdViewLoaded(new AdViewLinstener() {
            @Override
            public void OnAdViewLoadFail() {
                Log.d("Ad Response Result", "請求廣告失敗");
            }

            @Override
            public void OnAdViewLoadSuccess() {

                Log.d("Ad Response Result", "成功請求廣告");

                //顯示banner廣告
                ad.show();
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
