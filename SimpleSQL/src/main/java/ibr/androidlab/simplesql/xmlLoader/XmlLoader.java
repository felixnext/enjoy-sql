package ibr.androidlab.simplesql.xmlLoader;

import java.util.ArrayList;

import ibr.androidlab.simplesql.xmlLoader.storytelling.*;
import ibr.androidlab.simplesql.xmlLoader.data.Task;
import ibr.androidlab.simplesql.xmlLoader.storytelling.StoryTelling;


//import org.jdom2;

/**
 * @author Arne Brüsch
 * Controller that provides you with stories
 */
public class XmlLoader {

    private static XmlLoader xmlloader; 
    private ArrayList<StoryAbstract> stories;


    public ArrayList<StoryAbstract> getAvailableStories() {
        return stories;
    }

    public Story getStoryByAbstract(StoryAbstract abstr) {
        StoryTelling[] storytelling= {
            // TODO determining res-path (probably android-dependent)
            // TODO also needed for database-content
            new Image("PAth to file"),
            new Text("Lorem ipsum dolor sit ahmed, consectetuer adispiscit...")
        };
        Task task1 = new Task(1,"Beginner",new String[]{"Join"},1500,storytelling,new int[]{},
            "SELECT * FROM Kleider WHERE farbe=\"rot\"");
        Task task2 = new Task(2,"Intermediate",new String[]{"Left-Outer Join"}, 2000, storytelling,
                new int[]{1},"SELECT name FROM Person AS p WHERE p.id IN (SELECT id FROM attending_party)");
        Task task3 = new Task(3,"Specialist",new String[]{"Semi Join"},3500, storytelling, new int[]{1,2},
                "SELECT recipe FROM drinks WHERE name=\"martini\"");
        return new Story("Mixed Pickles",2342, new String[]{},new Task[]{task1,task2,task3});
    }

    private void checkForNewStories() {
    }

    private XmlLoader() {
        stories.add(new StoryAbstract(2342,"Mixed Pickles"));
    }

    public static XmlLoader getInstance() {
        if (xmlloader == null ) {
            xmlloader = new XmlLoader();
        }
        return xmlloader;
    }
}
