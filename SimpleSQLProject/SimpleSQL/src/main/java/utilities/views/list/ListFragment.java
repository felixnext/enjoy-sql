package utilities.views.list;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.ArrayAdapter;

import ibr.androidlab.simplesql.Database.SharedData;
import ibr.androidlab.simplesql.R;
import ibr.androidlab.simplesql.xmlLoader.data.Table;

/**
 * Fragment for the Display of table contents
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //process: bind the fragment layout to the code file
        return inflater.inflate(ibr.androidlab.simplesql.R.layout.list_fragement, container, false);


    }

    /**
	 * Binds the given table array to the interface fragment
	*/
    public void bindTables(Table[] tables) {
    	//TODO attach tables to this fragment
        //process: create the adapter using the shared data component for all tables
        ArrayAdapter adapter = new ArrayAdapter<Table>(this, R.drawable.big_join_table, SharedData.getInstance().currentStory.tables);
        ListView listView = (ListView) getView().findViewById(R.id.joinMainList);
        listView.setAdapter(adapter);

        //process: create the adapter using the shared data component for the joined tables

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}