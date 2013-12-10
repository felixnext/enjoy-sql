package ibr.androidlab.simplesql.xmlLoader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.content.res.Resources;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import ibr.androidlab.simplesql.xmlLoader.data.Table;
import ibr.androidlab.simplesql.xmlLoader.storytelling.*;
import ibr.androidlab.simplesql.xmlLoader.data.Task;
import ibr.androidlab.simplesql.xmlLoader.storytelling.StoryTelling;



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

    /**
     * Taking care of Table Subtree in Story-XML
     * @param parser
     * @return
     * @throws XmlPullParserException
     */
    private Table[] parseTableNames(XmlPullParser parser) throws XmlPullParserException,IOException {
        parser.require(XmlPullParser.START_TAG,null,"Tables");
        ArrayList<Table> tableName = new ArrayList<Table>();

        while(parser.next() != XmlPullParser.END_TAG) {
            if (parser.getName().equals("Table")) {
                parser.require(XmlPullParser.START_TAG,null,"Table");
                tableName.add(new Table(parser.getText()));
                parser.require(XmlPullParser.END_TAG, null, "Table");
            }
        }

        parser.require(XmlPullParser.END_TAG,null,"Tables");
        Table[] array = null;
        return tableName.toArray(array);
    }

    /**
     *
     * @param parser
     * @return
     * @throws XmlPullParserException
     */
    private Task[] parseTasks(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        parser.require(XmlPullParser.START_TAG,null,"Tasks");
        while(parser.next() != XmlPullParser.END_TAG) {
            tasks.add(this.parseTask(parser));
        }
        parser.require(XmlPullParser.END_TAG,null,"Tasks");
        Task[] t = null;
        return tasks.toArray(t);
    }

    private Task parseTask(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG,null,"Task");
        // acquiring taskID and -name
        String taskID = parser.getAttributeValue(0);
        String taskName = parser.getAttributeValue(1);

        String level = null;
        ArrayList<String> operators = new ArrayList<String>();
        ArrayList<Integer> postTask = new ArrayList<Integer>();
        StoryTelling[] telling = null;
        String resultSet = null;
        String reward = null;

        while(parser.next() != XmlPullParser.END_TAG) {
             if (parser.getName().equals("StoryTelling")) {
                telling = parseStoryTelling(parser);

            } else if (parser.getName().equals("Level")) {
                 level = parser.getText();

            } else if (parser.getName().equals("Operators")) {
                 parser.require(XmlPullParser.START_TAG,null,"Operators");

                 while(parser.next() != XmlPullParser.END_TAG) {
                     operators.add(parser.getText());
                 }

                 parser.require(XmlPullParser.END_TAG,null,"Operators");
            } else if (parser.getName().equals("CanFollow")) {
                 parser.require(XmlPullParser.START_TAG,null,"PostTask");
                 while(parser.next() != XmlPullParser.END_TAG) {
                     postTask.add(Integer.parseInt(parser.getText()));
                 }
                 parser.require(XmlPullParser.END_TAG,null,"PostTask");

            } else if (parser.getName().equals("ResultSet")) {
                 resultSet = parser.getText();
            } else if (parser.getName().equals("Reward")) {
                 reward = parser.getText();
            }

        }
        parser.require(XmlPullParser.END_TAG,null,"Task");
        String[] to = null;
        Integer[] in = null;
        // building Task-instance and returning
        return new Task(taskID,taskName,level,operators.toArray(to),Integer.parseInt(reward),telling,
                postTask.toArray(to),resultSet);
    }

    /**
     * This has to be changed if new implementations of the StoryTelling interface are added.
     * @param parser
     * @return
     * @throws XmlPullParserException
     * @throws IOException
     */
    private StoryTelling[] parseStoryTelling(XmlPullParser parser) throws XmlPullParserException,
            IOException {
        ArrayList<StoryTelling> telling = new ArrayList<StoryTelling>();
        parser.require(XmlPullParser.START_TAG,null,"StoryTelling");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getName().equals("Image")) {
                telling.add(new Image(parser.getText()));
            } else if (parser.getName().equals("Text")) {
                telling.add(new Text(parser.getText()));
            }
        }
        parser.require(XmlPullParser.END_TAG,null,"StoryTelling");

        StoryTelling[] tell = null;
        return telling.toArray(tell);
    }

    public Story getStoryByAbstract(StoryAbstract abstr) {
        Table[] tableNames = null;
        Task[] tasks = null;
        String id = null;
        String name = null;
        // reading Story in
        try {
            // Perhaps some prefix for home directory here?
            FileInputStream fIn = new FileInputStream("~/.enjoy-sql/" + abstr.id+abstr.title + ".xml");
            InputStreamReader is = new InputStreamReader(fIn);
            XmlPullParser parser = Xml.newPullParser();

            parser.setInput(is);
            parser.require(XmlPullParser.START_DOCUMENT,null,"story");
            // Query story's name and id
            if(parser.getAttributeCount() == 2) {
                name = parser.getAttributeValue(0);
                id = parser.getAttributeValue(1);
            }
            while (parser.next() != XmlPullParser.END_DOCUMENT) {
            /*    if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }*/
                String tagName = parser.getName();

                // Starts by looking for the entry tag
                if (tagName.equals("Tables")) {
                    tableNames = this.parseTableNames(parser);
                } else if (tagName.equals("Tasks")) {
                    tasks = this.parseTasks(parser);
                }

            }
        } catch (IOException io) {
            io.printStackTrace();
        } catch (XmlPullParserException xml) {
            xml.printStackTrace();
        }




//        StoryTelling[] storytelling= {
//            new Text("Tell me the name, Samuel Langhorne Clemens is better known by!")
//        };
//        Task task1 = new Task(1,"Beginner",new String[]{"Join"},1500,storytelling,new int[]{},
//            "SELECT pseudonym FROM authors WHERE name=\"Samuel Langhorne Clemens\"");
//        Task task2 = new Task(2,"Intermediate",new String[]{"Left-Outer Join"}, 2000, storytelling,
//                new int[]{1},"SELECT name FROM Person AS p WHERE p.id IN (SELECT id FROM attending_party)");
//        Task task3 = new Task(3,"Specialist",new String[]{"Semi Join"},3500, storytelling, new int[]{1,2},
//                "SELECT recipe FROM drinks WHERE name=\"martini\"");
//        return new Story("Mixed Pickles","2342", new String[]{},new Task[]{task1,task2,task3});
        return new Story(name,id,tableNames,tasks);
    }


    private void checkForNewStories() {
    }

    private XmlLoader() {
        stories = new ArrayList<StoryAbstract>();
        stories.add(new StoryAbstract("01","Example Story"));
    }

    public static XmlLoader getInstance() {
        if (xmlloader == null ) {
            xmlloader = new XmlLoader();
        }
        return xmlloader;
    }
}
