package utilities.views.table;

import ibr.androidlab.simplesql.xmlLoader.data.Table;

/**
 * Created by yevgen on 08.12.13.
 */
public class ViewTable {

    private Table table;
    private String[][] content;
    private TableCell[][] tableFormats;

    public ViewTable(Table table) {
        this.table = table;
        content = table.getTableContent();
        tableFormats = new TableCell[content.length][content[0].length];
    }


}
