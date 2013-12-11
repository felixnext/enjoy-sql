package ibr.androidlab.simplesql.Database;

import ibr.androidlab.simplesql.xmlLoader.Story;

import java.util.ArrayList;
import java.util.List;

/**
 * Data class with Singleton access to provide some shared values
 */
public class SharedData {

    private static SharedData instance = new SharedData();

    /**
     * Holds the story that is currently used
     */
    public Story currentStory;

    /**
     * Holds the list of tables that should be joined
     */
    public List<String> joinTables;

    /**
     * Private Constructor
     */
    private SharedData() {
        currentStory = null;
        joinTables = new ArrayList<String>();
    }

    /**
     * Converts the list of join tables into an array for the list adapter
     * @return the converted array
     */
    public String[] getJoinTablesArray() {
        return joinTables.toArray(new String[0]);
    }

    /**
     * Clears all join data (in case of a new story/mission
     */
    public void clearJoinData() {
        joinTables.clear();
    }

    /**
     * Provides the singleton access
     * @return the singleton of this class
     */
    public static SharedData getInstance() {
        return instance;
    }
}
