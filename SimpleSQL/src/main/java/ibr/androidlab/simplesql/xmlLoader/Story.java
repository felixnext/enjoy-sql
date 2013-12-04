package ibr.androidlab.simplesql.xmlLoader;

import ibr.androidlab.simplesql.xmlLoader.data.Task;

public class Story {

        public final String title;
        /** Unique id for story */
        public final int id;
        /**relational schema tables */
        public final String[] tables;
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
        public Story(String title, int id, String[] tables,Task[] tasks) {
            this.title = title;
            this.id = id;
            this.tables=tables;
            this.tasks=tasks;
        }
}
