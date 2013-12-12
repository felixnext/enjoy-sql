package utilities.views.cond;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ibr.androidlab.simplesql.R;

/**
 * Created by yevgen on 10.12.13.
 */
public class ColumnsFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    private SelectedColumnsDeliverer deliverer;
    private String item = "";

    /**
     * Interface for communication with parents activity
     */
    public interface SelectedColumnsDeliverer {
        public String[] getSectedColumns();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.columns_fragment, container, false);

        String[] columns = deliverer.getSectedColumns();

        if (columns == null) {
            //TODO what happens?
        }

        Spinner sp = (Spinner) view.findViewById(R.id.column_name);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, columns);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setPrompt("Attribute");
        if (columns.length > 0) {
            sp.setSelection(0);
        }
        sp.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            deliverer = (SelectedColumnsDeliverer) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    public String getSelectedItem() {
        return item;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        item = parent.getItemAtPosition(pos).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
