package ibr.androidlab.simplesql.xmlLoader.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by arne on 06.12.13.
 */
public class Table {
    private String name;
    // only accessible after getTableContent was called first
    private String[] columns;
    private String[] types;

    public Table(String name) {
        this.name = name;
        columns = null;
        types = null;
    }

    public String[] getColumns() {
        return columns;
    }

    public String[] getTypes() {
        return types;
    }


    public String[][] getTableContent(String table) {
        ArrayList<String[]> rows = new ArrayList<String[]>();
        String[] row = null;
        try {
            // some prefix missing? perhaps like this? TODO
            FileInputStream file = new FileInputStream("~/.enjoysql/" + table + ".csv");
            InputStreamReader in = new InputStreamReader(file);
            BufferedReader reader = new BufferedReader(in);



            String tablesNTypes = reader.readLine();
            int count = countOccurrences(tablesNTypes, ';');
            row = new String[count];

            StringTokenizer columnTypeTokens = new StringTokenizer(tablesNTypes,";");

            String[] stringArray = null;
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<String> types = new ArrayList<String>();
            while(columnTypeTokens.hasMoreTokens()) {
                String[] colType = columnTypeTokens.nextToken().split(":");
                columns.add(colType[0]);
                types.add(colType[1]);
            }

            this.columns = columns.toArray(stringArray);
            this.types = types.toArray(stringArray);


            while (true) {
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line,";");

                for (int i=0;i<count;i++) {
                    if (tokenizer.hasMoreTokens()) {
                        row[i] = tokenizer.nextToken();
                    }
                    rows.add(row);
                }

                if (line != null) {

                } else {
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new String[1][1];
    }
    public static int countOccurrences(String haystack, char needle) {

        int count = 0;
        for (int i=0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle) {
                count++;
            }
        }
        return count;
    }
}
