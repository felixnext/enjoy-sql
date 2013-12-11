package ibr.androidlab.simplesql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import utilities.views.cond.ColumnsFragment;

/**
 * Created by yevgen on 10.12.13.
 */
public class ConditionsView extends Activity implements ColumnsFragment.SelectedColumnsDeliverer {

    final public static String SELECTED_COLUMNS = "sected_columns";

    private String[] selectedColumns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comdition_view);

        //TODO send intent
        Intent intent = getIntent();
        if(intent != null) {
            selectedColumns = intent.getStringArrayExtra(SELECTED_COLUMNS);
        }



    }

    @Override
    public String[] getSectedColumns() {
        return selectedColumns;
    }
}
