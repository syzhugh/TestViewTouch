package com.sun.test.testviewtouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        WifiManager wifi_service = (WifiManager) getApplicationContext()
//                .getSystemService(WIFI_SERVICE);
//        WifiInfo wifiInfo = wifi_service.getConnectionInfo();
//        Log.i(TAG, "getLinkSpeed:" + wifiInfo.getLinkSpeed());
//        Log.i(TAG, "getRssi:" + wifiInfo.getRssi());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        String action = MotionEvent.actionToString(event.getAction());
        Log.i(TAG, action + "*********************start*********************");
        Log.i(TAG, "------MainActivity------dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
        Log.i(TAG, "------MainActivity------dispatchTouchEvent---return:" + dispatchTouchEvent);
        Log.i(TAG, action + "**********************end**********************");
        return dispatchTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MainActivity------onTouchEvent");
        boolean touchEvent = super.onTouchEvent(event);
        Log.i(TAG, "------MainActivity------onTouchEvent---return:" + touchEvent);
        return touchEvent;
    }
}
