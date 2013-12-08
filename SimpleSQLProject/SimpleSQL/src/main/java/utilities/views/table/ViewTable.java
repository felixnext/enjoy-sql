package utilities.views.table;

import ibr.androidlab.simplesql.xmlLoader.data.Table;

/**
 * Created by yevgen on 08.12.13.
 */
public class ViewTable {

    private Table table;
    private TableCell[][] tableFormats;

    public ViewTable(Table table) {
        this.table = table;
        //TODO right size
        tableFormats = new TableCell[1][1];
    }
}
