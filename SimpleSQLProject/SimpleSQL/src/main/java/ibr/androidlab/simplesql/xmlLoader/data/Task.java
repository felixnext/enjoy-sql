package ibr.androidlab.simplesql.xmlLoader.data;

import ibr.androidlab.simplesql.xmlLoader.storytelling.StoryTelling;
import java.util.ArrayList;

public class Task {

    /** Tasks ID that is unique
     * in this story
     */
    public final String id;

    /**
     * The Tasks name. Needn't be unique.
     */
    public final String name;
    
    /**
     * Fulltext and images (or probably arbitrary data used
     * to tell the story).
     * @see StoryTelling
     */
    public final StoryTelling[] storyTelling;

    /** Level in {Beginner, Intermediate, Specialist}
     * Default is "Beginner".*/
    public final String level;

    /** Operator(s) the tasks takes special care of */
    public final String[] operators;
    
    public final int reward;
    
    /** Adjacency list for tasks */
    public final String[] canFollow;
    /** ArrayList of right correctQuery - Columns are
     * Taskdependent
     */
    public final String correctQuery;

    public Task(String id,String name,String level,String[] operators,int reward,
            StoryTelling[] storyTelling,String[] canFollow, String correctQuery) {
        this.id = id;
        if (level.equals("Beginner") || level.equals("Intermediate")
                || level.equals("Specialist")) {
            this.level = level;
        } else {
            this.level="Beginner";
        }
        this.name = name;
        this.operators = operators;
        this.reward = reward;
        this.storyTelling = storyTelling;
        this.correctQuery = correctQuery;
        this.canFollow = canFollow;
    }

}
