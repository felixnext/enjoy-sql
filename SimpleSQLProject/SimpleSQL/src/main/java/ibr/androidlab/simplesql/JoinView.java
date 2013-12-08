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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import ibr.androidlab.simplesql.xmlLoader.Story;
import utilities.views.MultiWordAutoCompleteView;

/**
 * Code behind file for the join/merge 
 */
public class JoinView extends Activity {

	/**
	 * Holds the names of the tables (single schemata only currently)
	*/
	List<String> joinTables = new ArrayList<String>();

	/**
	 * Holds all tables that are provided by the mission
	*/
	List<String[]> joinList = new LinkedList<String[]>();

	/**
	 * Holds the story of the current mission
	 */
	Story story;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	//process: load the interface
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.table_join_view);

        //init: get the story here
        //story = ;

        //TODO: might show loading interface here?

        //process: load join data

        //process: fill interface
        //MultiWordAutoCompleteView sqlField = (MultiWordAutoCompleteView) findViewById(R.id.query_field);
    }

    /**
     * Add class to the join list
     * @param table the (unique) name of the table that should be added
     */
    private void addTable(String table) {
    	//safty: check if the table exists (might not be neccessary)
        /*
    	if (!tables.contains(table))
    		return;*/
        //TODO Sorry Felix das war nicht kompilierbar
    	//process: add the table
    	joinTables.add(table);
    }

    /**
     * Change the position of the given table handle
     * @param id the current id of the table
     * @param new_id the position the table should be moved to
     */
    private void changeTablePos(int id, int new_id) {
    	//safty: check if the values are in bounds (otherwise)
    	if (id < 0 || id >= joinTables.size())
    		return;
    	if (new_id < 0)
    		new_id = 0;
    	if (new_id >= joinTables.size())
    		new_id = joinTables.size() - 1;

    	//process: change data
    	String tmp = (String)joinTables.get(id);
    	for (int i = id+1; i<joinTables.size(); i++) {
    		joinTables.set(i-1, (String)joinTables.get(i));
    	}
    	joinTables.add(tmp);
    }

    /**
     * Remove the given table from the list
     * @param id the current position in the list of the table (not the name since tables can be used multiple times)
     */
    private void removeTable(int id) {
    	//safty: check if id is in bounds
		if (id < 0 || id >= joinTables.size())
    		return;

    	//process: remove the data
    	joinTables.remove(id);
    }

    /**
 	 * Might be used to update the User Interface after joinlist was updated
   	*/
    private void updateUI() {
    	//TODO: implement this... PLEASE!
    }

    private void addTables() {
    	//process: iterate through all tables in the 
    	for (int i=0; i<story.tables.length; i++) {
    		//process: add table to the 
    	}
    }
}
