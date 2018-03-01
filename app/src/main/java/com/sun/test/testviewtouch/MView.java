package com.sun.test.testviewtouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

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
//        setClickable(true);
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
        Log.i(TAG, "------MView------onTouchEvent");
        boolean touchEvent = super.onTouchEvent(event);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                touchEvent = false;
//                break;
//        }
        Log.i(TAG, "------MView------onTouchEvent---return:" + touchEvent);
        return touchEvent;
    }
}
