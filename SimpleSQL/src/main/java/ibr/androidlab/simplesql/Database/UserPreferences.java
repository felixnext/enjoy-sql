package ibr.androidlab.simplesql.Database;

/**
 * Created by Saria on 28.11.2013.
 */
public class UserPreferences {
    // private variables

    int _prefID;
    String _language;
    Boolean _hintsOn;
    int _textsize;

    public  UserPreferences ()
    {

    }
    // constructor
    public UserPreferences (int prefId, String language, boolean hints, int textSize)
    {
        this._prefID = prefId;
        this._language = language;
        this._hintsOn = hints;
        this._textsize = textSize;

    }
    // constructor
    public UserPreferences (String language, boolean hints, int textSize)
    {
        this._language = language;
        this._hintsOn = hints;
        this._textsize = textSize;
    }

    // getting ID
    public int getID(){
        return this._prefID;
    }

    // setting id
    public void setID(int id){
        this._prefID = id;
    }

    // getting name
    public String getLanguage(){
        return this._language;
    }

    // setting name (EN_en, DE_de)
    public void setLanguage(String language){
        this._language = language;
    }

    // getting hints if on
    public Boolean getHints(){
        return this._hintsOn;
    }

    // setting email
    public void setHints(Boolean hints){
        this._hintsOn = hints;
    }

    // getting text size (if not normal)
    public int getTextSize(){
        return this._textsize;
    }

    // setting text size (if changed on the preferences)
    public void setTextSize(int textSize){
        this._textsize = textSize;
    }
}
