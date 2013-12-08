package ibr.androidlab.simplesql;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;
import android.app.FragmentManager;

import java.util.ArrayList;

import ibr.androidlab.simplesql.xmlLoader.Story;
import ibr.androidlab.simplesql.xmlLoader.StoryAbstract;
import ibr.androidlab.simplesql.xmlLoader.XmlLoader;
import ibr.androidlab.simplesql.xmlLoader.data.Table;
import ibr.androidlab.simplesql.xmlLoader.storytelling.Image;
import utilities.views.MultiWordAutoCompleteView;
import utilities.views.table.TableFragment;


public class StoryView extends Activity implements TableFragment.TableDeliverer {

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

        HorizontalScrollView childScroll = (HorizontalScrollView) findViewById(R.id.scrollViewTable);
        childScroll.getLayoutParams().height = ((int) (ScHgt(this) * SCROLL_VIEW_SIZE));


        ImageButton topArrow = (ImageButton) findViewById(R.id.ConvertTop);
        topArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(view.getContext(), R.anim.rotate_centre_clockwise);
                view.startAnimation(rotate);
                ImageButton downArrow = (ImageButton) findViewById(R.id.ConvertDown);
                downArrow.startAnimation(rotate);
            }
        });

        ImageButton downArrow = (ImageButton) findViewById(R.id.ConvertDown);
        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(view.getContext(), R.anim.rotate_centre);
                view.startAnimation(rotate);
                ImageButton topArrow = (ImageButton) findViewById(R.id.ConvertTop);
                topArrow.startAnimation(rotate);
            }
        });

        ImageButton joinView = (ImageButton) findViewById(R.id.TableJoinView);
        joinView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO start join view

            }
        });

        ImageButton conditionView = (ImageButton) findViewById(R.id.ConditionsView);
        conditionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO start condition view
            }
        });

        Button skipButton = (Button) findViewById(R.id.SkipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO skip mission
            }
        });

        Button processButton = (Button) findViewById(R.id.ProcessButton);
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO process query
            }
        });
    }

    public static double ScHgt(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        return display.getHeight();
    }

    @Override
    public Table deliverTable() {
        Table table = null;
        //TableFragment table  = (TableFragment) getFragmentManager().findFragmentById(R.id.table_fragment);

        ArrayList<StoryAbstract> stories = XmlLoader.getInstance().getAvailableStories();
        if (stories.size() > 0) {
            //TODO choice special story
            Story story = XmlLoader.getInstance().getStoryByAbstract(stories.get(0));
            Table[] tables = story.tables;
            if(tables.length > 0)  table = tables[0];
        } else {
            Log.v("STORY!!!", "Story did not load!");
        } 
        return table;
    }
}
