package utilities.views.list;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.ArrayAdapter;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import ibr.androidlab.simplesql.Database.SharedData;
import ibr.androidlab.simplesql.R;
import ibr.androidlab.simplesql.xmlLoader.data.Table;
import utilities.views.table.TableFragment;

/**
 * Fragment for the Display of table contents
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListFragment extends Fragment {

    /**
     * Create Listener for tables as anonymous functions
     */
    private OnItemClickListener mMainItemClickedHandler = new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            //TODO: start drag and drop events here
        }
    };

    /**
     * Create Listener for tables as anonymous functions
     */
    private OnItemClickListener mSideItemClickedHandler = new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            //TODO: start drag and drop events here
        }
    };
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //process: bind the fragment layout to the code file
        return inflater.inflate(R.layout.list_fragement, container, false);

        //process: bind the tables
        bindTables();
    }
       */
    /**
	 * Binds the given table array to the interface fragment
	*/
    /*
    public void bindTables() {
    	//TODO attach tables to this fragment
        //process: create the adapter using the shared data component for all tables
        ArrayAdapter adapter = new ArrayAdapter<Table>(this, R.drawable.big_join_table, SharedData.getInstance().currentStory.tables);
        ListView listView = (ListView) getView().findViewById(R.id.joinMainList);
        listView.setAdapter(adapter);

        //process: add the click listener to the mainJoinList
        listView.setOnItemClickListener(mMainItemClickedHandler);

        //process: create the adapter using the shared data component for the joined tables
        adapter = new ArrayAdapter<String>(this, R.drawable.small_join_table, SharedData.getInstance().getJoinTablesArray());
        listView = (ListView) getView().findViewById(R.id.joinSideList);
        listView.setAdapter(adapter);

        //process: add the click listener to the sideJoinList
        listView.setOnItemClickListener(mSideItemClickedHandler);
    }
    */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}