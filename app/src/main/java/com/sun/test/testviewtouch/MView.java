package com.sun.test.testviewtouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MView extends View {

    private final String TAG = "Test";

    public MView(Context context) {
        this(context, null);
    }

    public MView(Context context,
            @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setClickable(true);
//        setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.i(TAG, "------MView------onTouch");
//                return true;
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MView------dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
        Log.i(TAG, "------MView------dispatchTouchEvent---return:" + dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MView------onTouchEvent" + MotionEvent
                .actionToString(event.getAction()));
        boolean touchEvent = super.onTouchEvent(event);
        switch (event.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                touchEvent = false;
//                break;
//            case MotionEvent.ACTION_DOWN:
//                touchEvent = true;
//                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG, "//////////////////////cancel////////////////////////");
                break;
        }
        Log.i(TAG, "------MView------onTouchEvent---return:" + touchEvent);
        return touchEvent;
    }
}
