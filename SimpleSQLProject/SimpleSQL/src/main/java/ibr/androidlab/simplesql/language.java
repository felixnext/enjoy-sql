package ibr.androidlab.simplesql;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.*;



//Activity for Splash screen
public class language extends Activity 
{
	private RadioGroup radioGroup1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.language);
	    } 
	
	 public void addListenerOnButton() {
		 
		 	radioGroup1 = (RadioGroup) findViewById(R.id.radio1);
		 	radioGroup1 = (RadioGroup) findViewById(R.id.radio0);
		 
		 
		  }
		}