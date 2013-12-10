package utilities.views.list;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ibr.androidlab.simplesql.R;
import ibr.androidlab.simplesql.xmlLoader.data.Table;
import utilities.views.table.TableFragment;

/**
<<<<<<< HEAD
 * Fragment for the Display of table contents
=======
 * Created by Felix on 09.12.13.
>>>>>>> parent of 9979616... updated todo list / updated sharedData singleton with story class
 */
public class ListFragment extends Fragment {
    @Override

        return null;
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
            deliverer = (TableFragment.TableDeliverer) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }
}