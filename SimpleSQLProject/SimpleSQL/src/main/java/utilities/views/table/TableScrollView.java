package utilities.views.table;

/**
 * Created by Yevgen Pikus on 24/11/13.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

class TableScrolelView extends android.widget.ScrollView {
    private int parent_id;

    public TableScrolelView(Context context) {
        super(context);
    }

    public TableScrolelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TableScrolelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        RelativeLayout rel = (RelativeLayout)this.getChildAt(0);
        ScrollView scroll = (ScrollView) rel.getChildAt(1);
        Log.v("TAG", "TOUCH");
        if(scroll.isInTouchMode()) {
            requestDisallowInterceptTouchEvent(true);}

        Log.v("CHILD", scroll.isFocused()+"");
        Log.v("FOCUSED CHILD", getFocusedChild().toString());
        // requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        RelativeLayout rel = (RelativeLayout)this.getChildAt(0);
        ScrollView scroll = (ScrollView) rel.getChildAt(1);

       // if(scroll.isInTouchMode()) {
         //   requestDisallowInterceptTouchEvent(true);}

        Log.v("TAG", "INTERCEPT TOUCH");

        Log.v("CHILD", scroll.isFocused()+"");
        Log.v("FOCUSED CHILD", getFocusedChild().toString());
        return super.onInterceptTouchEvent(ev);
    }
}