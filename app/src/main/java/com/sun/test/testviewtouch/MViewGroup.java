package com.sun.test.testviewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Description:
 * Created by Sun Yaozong on 2018/1/27.
 * Job NO.:600168
 * Phone:15001288397
 * Email:sunyaozong@syswin.com
 * Person in charge:丁朋伟
 *
 * @author Sun Yaozong 600168 15001288397
 */

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
        Log.i(TAG, "------MViewGroup------dispatchTouchEvent" + MotionEvent.actionToString(event.getAction()));
//        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
//        Log.i(TAG, "------MViewGroup------dispatchTouchEvent---return:" + dispatchTouchEvent);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MViewGroup------onInterceptTouchEvent" + MotionEvent.actionToString(event.getAction()));
        boolean interceptTouchEvent = super.onInterceptTouchEvent(event);
//        interceptTouchEvent = true;
        Log.i(TAG, "------MViewGroup------onInterceptTouchEvent---return:" + interceptTouchEvent);
        return interceptTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MViewGroup------onTouchEvent" + MotionEvent.actionToString(event.getAction()));
        boolean onTouchEvent = super.onTouchEvent(event);
        Log.i(TAG, "------MViewGroup------onTouchEvent---return:" + onTouchEvent);
        return onTouchEvent;
    }
}
