package com.brosser.controller;

import android.view.MotionEvent;
import android.view.View;
import com.brosser.view.ElementView;;

/** Listen for taps. */
public final class TrackingTouchListener implements View.OnTouchListener {

    public TrackingTouchListener(ElementView view) {
    }

    @Override 
    public boolean onTouch(View v, MotionEvent evt) {
        switch (evt.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            default:
                return false;
        }

        return true;
    }
}