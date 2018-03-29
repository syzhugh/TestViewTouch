package com.sun.test.testviewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MViewGroup extends RelativeLayout {

    private final String TAG = "Test";

    public MViewGroup(Context context) {
        this(context, null);
    }

    public MViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MViewGroup------dispatchTouchEvent" + MotionEvent
                .actionToString(event.getAction()));
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
        Log.i(TAG, "------MViewGroup------dispatchTouchEvent---return:" + dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MViewGroup------onInterceptTouchEvent" + MotionEvent
                .actionToString(event.getAction()));
        boolean interceptTouchEvent = super.onInterceptTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                interceptTouchEvent = true;
                break;
        }
        Log.i(TAG, "------MViewGroup------onInterceptTouchEvent---return:" + interceptTouchEvent);
        return interceptTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MViewGroup------onTouchEvent" + MotionEvent
                .actionToString(event.getAction()));
        boolean onTouchEvent = super.onTouchEvent(event);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                onTouchEvent = false;
//                break;
//            case MotionEvent.ACTION_DOWN:
//                onTouchEvent = true;
//                break;
//        }
        Log.i(TAG, "------MViewGroup------onTouchEvent---return:" + onTouchEvent);
        return onTouchEvent;
    }
}
