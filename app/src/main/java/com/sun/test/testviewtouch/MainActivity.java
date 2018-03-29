package com.sun.test.testviewtouch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Span";
    private final String TAG1 = "click";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /**
     * 据说dialog消失后，继续出发up
     */
    private void testDialog() {
        findViewById(R.id.main_root).setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("123123123")
                        .setNegativeButton("cancel", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("ensure", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
                return true;
            }
        });
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
