package com.sun.test.testviewtouch;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class CustomLinkMovement extends LinkMovementMethod {

    private static CustomLinkMovement sInstance;
    private final String TAG = "Span";

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
