package com.sun.test.testviewtouch;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Description:
 * Created by Sun Yaozong on 2018/3/2.
 * Job NO.:600168
 * Phone:15001288397
 * Email:sunyaozong@syswin.com
 * Person in charge:丁朋伟
 *
 * @author Sun Yaozong 600168 15001288397
 */

public class CustomLinkMovement extends LinkMovementMethod {

    private final String TAG = "Span";

    private static CustomLinkMovement sInstance;

    public static CustomLinkMovement getInstance() {
        if (sInstance == null) {
            sInstance = new CustomLinkMovement();
        }
        return sInstance;
    }

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        Log.i(TAG, "------CustomLinkMovement------onTouchEvent-"
                + MotionEvent.actionToString(event.getAction()));
        boolean touchEvent = super.onTouchEvent(widget, buffer, event);
        Log.i(TAG, "CustomLinkMovement:" + touchEvent);
        return touchEvent;
    }
}
