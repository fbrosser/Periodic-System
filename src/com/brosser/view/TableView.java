package com.brosser.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class TableView extends View {
	
    public TableView(Context context, int height, int width) {
    	super(context);
        setMinimumWidth(width);
        setMinimumHeight(height);
        setFocusable(true);
    }
    
    public TableView(Context context) {
    	super(context);
        setMinimumWidth(180);
        setMinimumHeight(200);
        setFocusable(true);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(
            getSuggestedMinimumWidth(),
            getSuggestedMinimumHeight());
    }
    
    @Override 
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setColor(hasFocus() ? Color.BLUE : Color.GRAY);
        canvas.drawRect(0, 0, getWidth() - 1, getHeight() -1, paint);
        
        paint.setStyle(Style.FILL);
        paint.setColor(hasFocus() ? Color.RED : Color.GREEN);
    }
}
