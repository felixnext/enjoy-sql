package utilities.views.table;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by Yevgen Pikus on 24/11/13.
 */
public class TableCell extends TextView {

    private int colorType;
    private int colorTypeTouched;
    private boolean touched;
    private boolean head;

    public TableCell(Activity activity, int colorType, int colorTypeTouched, boolean head) {
        super(activity);
        this.colorType = colorType;
        this.colorTypeTouched = colorTypeTouched;
        this.touched = false;
        this.head = head;
    }

    private void touch() {
        touched = true;
        setBackground(getResources().getDrawable(colorTypeTouched));
    }

    private void untouch() {
        touched = false;
        setBackground(getResources().getDrawable(colorType));
    }


    /**
     * Change color between touched and untouched witch respect to state.
     */
    public void swap() {
        if (!head) {
            if (touched) untouch();
            else touch();
        }

    }

    public boolean isSelected() {
        return touched;
    }
}
