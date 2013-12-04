import ibr.androidlab.simplesql.Database.User;
import ibr.androidlab.simplesql.xmlLoader.data.Task;

interface UserDataStoring {

	public boolean saveQuery(String query, String exercise, String user);

	public String getQuery(String exercise, String user);

    //public boolean saveState(Task, User)

}