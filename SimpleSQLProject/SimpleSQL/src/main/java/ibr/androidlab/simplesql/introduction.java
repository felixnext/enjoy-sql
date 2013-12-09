package ibr.androidlab.simplesql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.*;

//Activity for Splash screen
public class introduction extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent("com.example.question"));
            }
        });
    } 
}