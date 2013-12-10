package ibr.androidlab.simplesql.xmlLoader.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by arne on 06.12.13.
 */
public class Table {

    private String name;
    // workaround for DropBox purposes ;-)
    private String id;

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    // only accessible after getTableContent was called first
    private String[] columns;
    private String[] types;
    private int rowCount;

    public void setContent(String[][] content) {
        this.content = content;
    }

    private String[][] content;

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

    public int getRowCount() {
        return rowCount;
    }

    public String getName() {
        return name;
    }

    /**
     * Important: columns, types and rowcount are only available, after this method was called.
     * @return two-dimensional Array containing the table Content.
     */
    public String[][] getTableContent() {
        if(content!=null) return content;
        ArrayList<String[]> rows = new ArrayList<String[]>();
        String[] row = null;
        try {
            // some prefix missing? perhaps like this? TODO
            URL url = new URL("https://www.dropbox.com/s/" + id + "/" + name + ".csv");
            InputStreamReader in = new InputStreamReader(url.openStream());
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
        String[][] twoDimArray = null;
        rowCount = rows.size();
        content = rows.toArray(twoDimArray);
        return content;
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
