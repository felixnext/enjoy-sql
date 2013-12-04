package ibr.androidlab.simplesql.Database;

/**
 * Created by Saria on 28.11.2013.
 */
public class User {

    // private variables
    int _userId;
    String _userName;
    String _email;
    int _score;

    public User ()
    {

    }
       // constructor
    public User (int userId, String userName, String email, int score)
    {
        this._userId = userId;
        this._userName = userName;
        this._email = email;
        this._score = score;

    }
    // constructor
    public User (String userName, String email, int score){
        this._userName = userName;
        this._email = email;
        this._score = score;
    }
    // getting ID
    public int getID(){
        return this._userId;
    }

    // setting id
    public void setID(int id){
        this._userId = id;
    }

    // getting name
    public String getName(){
        return this._userName;
    }

    // setting name
    public void setName(String name){
        this._userName = name;
    }

    // getting email
    public String getEmail(){
        return this._email;
    }

    // setting email
    public void setEmail(String email){
        this._email = email;
    }

    // getting score
    public int getScore(){
        return this._score;
    }

    // setting score
    public void setScore(int score){
        this._score = score;
    }
}