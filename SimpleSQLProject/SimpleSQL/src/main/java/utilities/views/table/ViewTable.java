package utilities.views.table;

import ibr.androidlab.simplesql.xmlLoader.data.Table;

/**
 * Created by yevgen on 08.12.13.
 */
public class ViewTable {

    private Table table;
    private String[][] content;
    private TableCell[][] tableFormats;
    private String[] columns;

    /**
     *
     * @param table Correlated Table-object of this view table.
     */
    public ViewTable(Table table) {
        this.table = table;
        content = table.getTableContent();
        columns = table.getColumns();
        tableFormats = new TableCell[content.length][content[0].length];
    }


    /**
     * This Method select one column in the Table of FragmentActivit and highlights it.
     * @param columnName Name of column that should be selected
     */
    public void selectColumn(String columnName){
        for(int i = 0; i < columns.length; i++){
            if(columns[i].equals(columnName)){
                selectCollum(i);
                break;
            }
        }
    }

    /**
     * This Method select one column in the Table of FragmentActivit and highlights it.
     * @param columnNumber Number of column that should be selected
     */
    public void selectCollum(int columnNumber) {
        for(TableCell[] column : tableFormats) {
            column[columnNumber].swap();
        }
    }

    /**
     * Set table cell.
     * @param rowNumber Number of row in Table.
     * @param columnNumber Number of column in Table.
     * @param tv Cell object.
     */
    public void setCell(int rowNumber, int columnNumber, TableCell tv) {
        tableFormats[rowNumber][columnNumber] = tv;
    }
}
