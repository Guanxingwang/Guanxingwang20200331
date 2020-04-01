package com.bawei.dome0331;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FlowView extends ViewGroup {
    public FlowView(Context context) {
        super(context);
    }
    public FlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public FlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onLayout(boolean check, int l, int t, int r, int b) {

        int zuo = 0;
        int shang = 0;
        int you = 0;
        int di = 0;

        int Count = getChildCount();
        if (Count > 0) {
            for (int i = 0; i < Count; i++) {
                View childAt = getChildAt(i);
                childAt.measure(0, 0);
                int measuredHeight = childAt.getMeasuredHeight();
                int measuredWidth = childAt.getMeasuredWidth();

                you = zuo + measuredWidth;
                if (you  > getMeasuredWidth()) {
                    zuo = 0;
                    you = zuo + measuredWidth;
                    shang = di + 20;
                }

                di = shang + measuredHeight;
                childAt.layout(zuo, shang, you, di);
                zuo += measuredWidth + 20;

            }
        }

    }

    public void addChildView(String title) {
        TextView textView = new TextView(getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(8, 0, 8, 0);
        textView.setTextColor(Color.BLACK);
        textView.setText(title);
        addView(textView);
    }

}
