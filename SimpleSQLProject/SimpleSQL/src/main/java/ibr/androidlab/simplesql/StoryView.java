package ibr.androidlab.simplesql;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import utilities.views.MultiWordAutoCompleteView;


public class StoryView extends Activity {

    final String[] array = {"SELECT", "FROM", "DISTINCT", "AS", "WHERE", "LIKE", "ORDER BY",
            "INNER JOIN", "ON", "IS NULL"};

    final double SCROLL_VIEW_SIZE = 0.5; //precent of display size

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);

        //auto complete for sql keywords
        MultiWordAutoCompleteView sqlField = (MultiWordAutoCompleteView) findViewById(R.id.query_field);
        sqlField.setSeparator(" ");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, array);
        sqlField.setThreshold(1);
        sqlField.setAdapter(adapter);

        //image in header of table
        /*
        TextView tv = (TextView) findViewById(R.id.TextView12);
        Resources res = getResources();
        Drawable img = res.getDrawable(R.drawable.trichter);
        img.setBounds(0, 0, 50, 50);
        tv.setCompoundDrawables(null,null,img,null);
        */

        ScrollView childScroll = (ScrollView) findViewById(R.id.scrollViewTable);
        childScroll.getLayoutParams().height = ((int) (ScHgt(this) * SCROLL_VIEW_SIZE));

        ScrollView parentScroll = (ScrollView) findViewById(R.id.mainScrollView);

        /*
        parentScroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                Log.v("TAG","PARENT TOUCH");
                findViewById(R.id.scrollViewTable).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        childScroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event)
            {
                Log.v("TAG","CHILD TOUCH");
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });*/
    }

    public static double ScHgt(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        return display.getHeight();
    }

}
