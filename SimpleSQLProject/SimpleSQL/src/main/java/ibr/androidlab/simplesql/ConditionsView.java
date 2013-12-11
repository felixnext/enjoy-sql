package ibr.androidlab.simplesql;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import utilities.views.cond.ColumnsFragment;

/**
 * Created by yevgen on 10.12.13.
 */
public class ConditionsView extends Activity implements ColumnsFragment.SelectedColumnsDeliverer {

    final public static String SELECTED_COLUMNS = "sected_columns";

    private String[] selectedColumns;

    //spinner with selected items
    private ColumnsFragment columnSpinner1  = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner1);
    private ColumnsFragment columnSpinner2  = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner2);
    private ColumnsFragment columnSpinner3  = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner3);
    private ColumnsFragment columnSpinner4  = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner4);
    private ColumnsFragment columnSpinner5  = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner5);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comdition_view);

        //TODO send intent
        Intent intent = getIntent();
        if(intent != null) {
            selectedColumns = intent.getStringArrayExtra(SELECTED_COLUMNS);
        }

        createOperatorsSpinner();

        

    }

    private void createOperatorsSpinner() {
        Spinner sp = (Spinner) findViewById(R.id.operator);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setPrompt("Operator");
        sp.setSelection(0);

    }

    @Override
    public String[] getSectedColumns() {
        return selectedColumns;
    }
}
