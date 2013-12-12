package ibr.androidlab.simplesql;

import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import utilities.views.cond.ColumnsFragment;

/**
 * Created by yevgen on 10.12.13.
 */
public class ConditionsView extends Activity implements ColumnsFragment.SelectedColumnsDeliverer {

    final public static String SELECTED_COLUMNS = "sected_columns";

    private String[] selectedColumns;

    //spinner with selected items
    private ColumnsFragment columnSpinner1 = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner1);
    private ColumnsFragment columnSpinner2 = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner2);
    private ColumnsFragment columnSpinner3 = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner3);
    private ColumnsFragment columnSpinner4 = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner4);
    private ColumnsFragment columnSpinner5 = (ColumnsFragment) getFragmentManager().findFragmentById(R.id.columns_spinner5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null) {
            selectedColumns = intent.getStringArrayExtra(SELECTED_COLUMNS);
            Log.v("ConditionView", "Columns delivered");
        } else {
            Log.v("ConditionView", "intent == NULL");
        }

        setContentView(R.layout.condition_view);

        //create all spinners
        createOperatorsSpinner();
        createNullSpinner();
        createLikeSpinner();
        createBetweenSpinner();
        createInSpinner();

        //set drag and drop actions
        TextView operatorField = (TextView) findViewById(R.id.drag_field1);
        operatorField.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    view = (View) findViewById(R.id.operatorsList);
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(data, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });

        ListView listView = (ListView)findViewById(R.id.conditionSideList);
        listView.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_droptarget));
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape));
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        //View view = (View) event.getLocalState();
                        //ViewGroup owner = (ViewGroup) view.getParent();
                        //owner.removeView(view);
                        //LinearLayout container = (LinearLayout) v;
                        //container.addView(view);
                        //view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        v.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape));
                    default:
                        break;
                }
                return true;
            }

        });

    }

    private void createInSpinner() {
        Spinner sp = (Spinner) findViewById(R.id.in);
        String[] options = {"IN", "NOT IN"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        sp.setAdapter(adapter);
        sp.setSelection(0);
        //TODO on click listener
    }


    /**
     * Create the spinner with BETWEEN and NOT BETWEEN opportunities
     */
    private void createBetweenSpinner() {
        Spinner sp = (Spinner) findViewById(R.id.between);
        String[] options = {"BETWEEN", "NOT BETWEEN"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        sp.setAdapter(adapter);
        sp.setSelection(0);
        //TODO on click listener
    }

    /**
     * Create the spinner with LIKE and NOT LIKE opportunities
     */
    private void createLikeSpinner() {
        Spinner sp = (Spinner) findViewById(R.id.like);
        String[] options = {"LIKE", "NOT LIKE"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        sp.setAdapter(adapter);
        sp.setSelection(0);
        //TODO on click listener
    }

    /**
     * Create the spinner for NOT NULL and NULL options
     */
    private void createNullSpinner() {
        Spinner sp = (Spinner) findViewById(R.id.n0ll);
        String[] options = {"NULL", "NOT NULL"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        sp.setAdapter(adapter);
        sp.setSelection(0);
        //TODO on click listener
    }

    /**
     * Create the spinner with different operators e.g. =; >=, <=
     */
    private void createOperatorsSpinner() {
        Spinner sp = (Spinner) findViewById(R.id.operator);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        sp.setAdapter(adapter);
        sp.setPrompt("Operator");
        sp.setSelection(0);
        //TODO on item click listener
    }

    @Override
    public String[] getSectedColumns() {
        return selectedColumns;
    }
}
