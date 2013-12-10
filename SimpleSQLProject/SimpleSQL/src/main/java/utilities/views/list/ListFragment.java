package utilities.views.list;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            deliverer = (TableDeliverer) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}