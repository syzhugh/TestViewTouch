package com.sun.test.testviewtouch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Description:
 * Created by Sun Yaozong on 2018/3/1.
 * Job NO.:600168
 * Phone:15001288397
 * Email:sunyaozong@syswin.com
 * Person in charge:丁朋伟
 *
 * @author Sun Yaozong 600168 15001288397
 */

public class MTextView extends android.support.v7.widget.AppCompatTextView {

    private final String TAG = "Span";

    public MTextView(Context context) {
        this(context, null);
    }

    public MTextView(Context context,
            @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MTextView(Context context,
            @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.i(TAG, "------MTextView------dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "------MTextView------onTouchEvent-"
                + MotionEvent.actionToString(event.getAction()));
        boolean result = super.onTouchEvent(event);
        Log.i(TAG, "MTextView:" + result);
        return result;
    }
}
