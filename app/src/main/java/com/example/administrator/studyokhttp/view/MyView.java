package com.example.administrator.studyokhttp.view;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureDimension(300, widthMeasureSpec);
        int height = measureDimension(200, heightMeasureSpec);
        setMeasuredDimension(width,height);
        Log.d("zzz",widthMeasureSpec+"heightMeasureSpec"+heightMeasureSpec);
    }

    private int measureDimension(int i, int widthMeasureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else {
            result = i;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return  result;
    }
}
