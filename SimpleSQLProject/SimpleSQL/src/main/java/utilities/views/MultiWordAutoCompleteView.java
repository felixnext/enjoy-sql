package utilities.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import java.util.Map;

public class MultiWordAutoCompleteView extends AutoCompleteTextView
{
    private static final String DEFAULT_SEPARATOR = ",";
    private String mSeparator = DEFAULT_SEPARATOR;

    public MultiWordAutoCompleteView(Context context)
    {
        super(context);
    }


    public MultiWordAutoCompleteView(Context context, AttributeSet attrs
                                    )
    {
        super(context, attrs);
    }


    public MultiWordAutoCompleteView(Context context, AttributeSet attrs,
                                      int defStyle)
    {
        super(context, attrs, defStyle);
    }

    /**
     * Gets the separator used to delimit multiple words. Defaults to ","
     if
     * never specified.
     */
    public String getSeparator()
    {
        return mSeparator;
    }

    /**
     * Sets the separator used to delimit multiple words. Defaults to ","
     if
     * never specified.
     *
     * @param separator
     */
    public void setSeparator(String separator)
    {
        mSeparator = separator;
    }

    @Override
    protected void performFiltering(CharSequence text, int keyCode)
    {
        String newText = text.toString();
        if (newText.indexOf(mSeparator) != -1)
        {
            int lastIndex = newText.lastIndexOf(mSeparator);
            if (lastIndex != newText.length() - 1)
            {
                newText = newText.substring(lastIndex + 1).trim();
                if (newText.length() >= getThreshold())
                {
                    text = newText;
                }
            }
        }
        super.performFiltering(text, keyCode);
    }

    @Override
    protected void replaceText(CharSequence text)
    {
        String newText = getText().toString();
        if (newText.indexOf(mSeparator) != -1)
        {
            int lastIndex = newText.lastIndexOf(mSeparator);
            newText = newText.substring(0, lastIndex + 1) + text.toString();
        }
        else
        {
            newText = text.toString();
        }
        super.replaceText(newText);
    }

}