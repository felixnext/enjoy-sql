package ibr.androidlab.simplesql.xmlLoader;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ibr.androidlab.simplesql.xmlLoader.data.Table;
import ibr.androidlab.simplesql.xmlLoader.data.Task;

public class Story {

        public final String title;
        /** Unique - possibly numerical - id for story */
        public final String id;
        /**relational schema tables */
        public final Table[] tables;
        /** tasks for the story. They all depend
             on the same schema. */
        public final Task[] tasks;

    /**
     *
     * @param title
     * @param id
     * @param tables
     * @param tasks
     */
        public Story(String title, String id, Table[] tables,Task[] tasks) {
            if(tables==null) {

            }
            this.title = title;
            this.id = id;
            this.tables=tables;
            this.tasks=tasks;
        }




}
