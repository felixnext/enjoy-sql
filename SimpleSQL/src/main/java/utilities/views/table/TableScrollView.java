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

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        // if(scroll.isInTouchMode()) {
        requestDisallowInterceptTouchEvent(true);
        //}


        return super.onInterceptTouchEvent(ev);
    }
}