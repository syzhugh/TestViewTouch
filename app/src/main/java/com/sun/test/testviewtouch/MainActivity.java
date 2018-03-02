package com.sun.test.testviewtouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Span";
    private final String TAG1 = "click";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        WifiManager wifi_service = (WifiManager) getApplicationContext()
//                .getSystemService(WIFI_SERVICE);
//        WifiInfo wifiInfo = wifi_service.getConnectionInfo();
//        Log.i(TAG, "getLinkSpeed:" + wifiInfo.getLinkSpeed());
//        Log.i(TAG, "getRssi:" + wifiInfo.getRssi());

        TextView tv = (TextView) findViewById(R.id.main_mtv);
        String str = "11111111111111111111111111111111111111111111111";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Log.i(TAG1, "------SpannableString------onClick");
            }
        }, 0, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(spannableString);
        tv.setMovementMethod(CustomLinkMovement.getInstance());
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG1, "------TextView------onClick");
            }
        });
        tv.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG1, "------TextView------onLongClick");
                return true;
            }
        });
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        String action = MotionEvent.actionToString(event.getAction());
//        Log.i(TAG, action + "*********************start*********************");
//        Log.i(TAG, "------MainActivity------dispatchTouchEvent");
//        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
//        Log.i(TAG, "------MainActivity------dispatchTouchEvent---return:" + dispatchTouchEvent);
//        Log.i(TAG, action + "**********************end**********************");
//        return dispatchTouchEvent;
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.i(TAG, "------MainActivity------onTouchEvent");
//        boolean touchEvent = super.onTouchEvent(event);
//        Log.i(TAG, "------MainActivity------onTouchEvent---return:" + touchEvent);
//        return touchEvent;
//    }
}
