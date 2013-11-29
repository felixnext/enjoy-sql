package ibr.androidlab.simplesql.xmlLoader.storytelling;

import android.graphics.BitmapFactory;
import android.graphics.Bitmap;

// probably just as string? Or should the image be able to read itself in?
// according to MVC, it should!
public class Image implements StoryTelling {

    public final String path;

    public Bitmap getBitmap() {
        return BitmapFactory.decodeFile(path);
    }

    public Image(String path) {
        this.path=path;
    }

}
