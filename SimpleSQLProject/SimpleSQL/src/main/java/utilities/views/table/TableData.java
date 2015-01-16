package utilities.views.table;

/**
 * Created on 23/11/13.
 * This class represent container for the data from table. Class assumes responsibility for loading the data from DB.
 */
public class TableData {

    private String[] tableHead;
    private String[][] tableData;
    private String name = "Test";

    public TableData(){
        //TODO get data
        createTestData();

    }

    public String getName() {
        return name;
    }

    private void createTestData() {
        String s = "test string";
        int rows = 10;
        int columns = 20;
        tableHead = new String[rows];
        tableData = new String[columns][rows];


        for(int i = 0; i< rows; i++){
            tableHead[i] = s + i;
        }

        for(int i = 0; i< columns; i++){
            for(int j = 0; j< rows; j++){
                tableData[i][j] = s;
            }
        }
    }

    /**
     * Return head row as string.
     * @return Return head row as string.
     */
    public  String[] getTableHead() {
        return tableHead;
    }

    /**
     * Return head row as string.
     * @return Return head row as string.
     */
    public String[][] getTableData() {
        return tableData;
    }


}
