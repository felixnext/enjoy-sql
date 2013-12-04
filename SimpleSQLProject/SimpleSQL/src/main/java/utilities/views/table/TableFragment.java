package utilities.views.table;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import ibr.androidlab.simplesql.R;

/**
 * Created by Yevgen Pikus on 23/11/13.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TableFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_fragment,container, false);
        TableLayout head = (TableLayout) view.findViewById(R.id.Header);
        TableLayout tb = (TableLayout) view.findViewById(R.id.Header);
        TableData data = new TableData();

        //add head to table
        head.addView(createRow(data.getTableHead(), R.drawable.table_top_orange, true));
        //add data to table
        for(int i = 0; i< data.getTableData().length; i++) {
            int type = i%2 == 0 ? R.drawable.table_cell_white : R.drawable.table_top_ye;
            tb.addView(createRow(data.getTableData()[i],type, false));
        }




        return view;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    /**
     * Create new table raw object with respect to cell type.
     * @param tableHead String array that contains the table raw data.
     * @param typeOfCell Type of cell format: White or colored Cells.
     * @return New TableRaw object filled with data.
     */
    protected TableRow createRow(String[] tableHead, int typeOfCell, boolean head) {
        TableRow row = new TableRow(getActivity());

        TableRow.LayoutParams tlparams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(tlparams);

        for(String content: tableHead) {
            TableCell tv = new TableCell(getActivity(), typeOfCell, R.drawable.table_cell_touched, head);
            tv.setTextColor(Color.BLACK);
            tv.setPadding(7, 5, 7, 5);
            tv.setBackground(getResources().getDrawable(typeOfCell));
            tv.setTextSize(getResources().getDimension(R.dimen.table_text_size));
            tv.setText(content);
            tv.setOnClickListener(new CellClickListener());
            row.addView(tv);
        }

        return row;
    }
}

class CellClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        ((TableCell)view).swap();
    }
}
