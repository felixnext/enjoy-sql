package ibr.androidlab.simplesql.Database;

import ibr.androidlab.simplesql.xmlLoader.Story;

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
     * Private Constructor
     */
    private SharedData() {
        currentStory = null;
    }

    /**
     * Provides the singleton access
     * @return the singleton of this class
     */
    public static SharedData getInstance() {
        return instance;
    }
}
