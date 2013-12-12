package utilities.views.table;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import ibr.androidlab.simplesql.R;
import ibr.androidlab.simplesql.xmlLoader.data.Table;

/**
 * Created by Yevgen Pikus on 23/11/13.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TableFragment extends Fragment {

    private int width = 0;

    private TableDeliverer deliverer;

    public ViewTable getViewTable() {
        return viewTable;
    }

    private ViewTable viewTable;

    public interface TableDeliverer {
        public Table deliverTable();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_fragment, container, false);
        TableLayout head = (TableLayout) view.findViewById(R.id.Header);
        TableLayout tb = (TableLayout) view.findViewById(R.id.TableData);

        //Data for table filling
        //TODO table communication & ViewTable
        TableData data = new TableData();
        String name = "";
        if (deliverer != null) {
            Table table = deliverer.deliverTable();
            if(table == null) table = createTable(data);
            name = "Table name: " + table.getName();
            viewTable = new ViewTable(table);
        }

        //add head to table
        head.addView(createRow(data.getTableHead(), R.drawable.table_top_orange, true, -1));
        //add data to table
        for (int i = 0; i < data.getTableData().length; i++) {
            int type = i % 2 == 0 ? R.drawable.table_cell_white : R.drawable.table_top_ye;
            tb.addView(createRow(data.getTableData()[i], type, false, i));
        }

        TextView tableName = (TextView) view.findViewById(R.id.TableName);
        tableName.setText(name);

        return view;
    }

    private Table createTable(TableData data) {
        Table table = new Table("Test Table");
        table.setColumns(data.getTableHead());
        table.setContent(data.getTableData());
        return table;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    /**
     * Create new table raw object with respect to cell type.
     * @param tableHead String array that contains the table raw data.
     * @param typeOfCell Type of cell format: White or colored Cells.
     * @return New TableRaw object filled with data.
     */
    protected TableRow createRow(String[] tableHead, int typeOfCell, boolean head, int rowNumber) {
        TableRow row = new TableRow(getActivity());


        TableRow.LayoutParams tlparams = new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(tlparams);


        for (int columnNumber = 0; columnNumber < tableHead.length; columnNumber++) {
            String content = tableHead[columnNumber];
            TableCell tv = new TableCell(getActivity(), typeOfCell, R.drawable.table_cell_touched, head);
            tv.setTextColor(Color.BLACK);
            tv.setBackground(getResources().getDrawable(typeOfCell));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.table_text_size));
            tv.setPadding(7, 5, 7, 5);

            if (head) {
                tv.setText(content + " \u25BC");
                tv.setOnClickListener(new HeadClickListener(viewTable));
            } else {
                tv.setText(content);
                tv.setOnClickListener(new CellClickListener());
                viewTable.setCell(rowNumber, columnNumber, tv);
            }


            tv.setTag(content);

            row.addView(tv);
        }

        if (head)
            width = row.getWidth();

        return row;
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

class HeadClickListener implements View.OnClickListener {

    private ViewTable viewTable;

    /**
     * @param viewTable Associated table view to this table fragment.
     */
    public HeadClickListener(ViewTable viewTable) {
        super();
        this.viewTable = viewTable;
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        viewTable.selectColumn(tag);
    }
}

class CellClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        //((TableCell) view).swap();
    }
}
