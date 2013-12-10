 package ibr.androidlab.simplesql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.*;

public class MainActivity extends Activity 
{
    private boolean mIsBackButtonPressed;
	//ProgressDialog progressBar;
	private int progressBarStatus = 0;
	private Handler progressBarHandler = new Handler();
	int fileSize = 0;
    ProgressBar progressBar;
	int myProgress = 0;
	
    @Override
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);                    
        setContentView(R.layout.splash);
    
        final TextView textProgressBar = (TextView) findViewById(R.id.textView1);
        textProgressBar.setText("Loading 10%");
        textProgressBar.setTextSize(18);

       progressBar = (ProgressBar) findViewById(R.id.progressBar1);
       // ProgressBar.show(MainActivity.this,"",getResources().getString(R.string.pleaseWait),true,false);
       
		progressBar.setProgress(0);
		progressBar.setMax(100);

		progressBarStatus = 0;
		fileSize = 0;

		new Thread(new Runnable() {
		  @Override
		public void run() {
			while (progressBarStatus < 100) {
				
			  progressBarStatus = doSomeTasks();
		
			  
			  try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }

			  progressBarHandler.post(new Runnable() {
				@Override
				public void run() {
				  progressBar.setProgress(progressBarStatus);
				  if (progressBarStatus == 20)
					  textProgressBar.setText("Loading 20%");	
				  if (progressBarStatus == 30)
					  textProgressBar.setText("Loading 30%");	
				  if (progressBarStatus == 40)
					  textProgressBar.setText("Loading 40%");	
				  if (progressBarStatus == 50)
					  textProgressBar.setText("Loading 50%");	
				  if (progressBarStatus == 60)
					  textProgressBar.setText("Loading 60%");	
				  if (progressBarStatus == 70)
					  textProgressBar.setText("Loading 70%");	
				  if (progressBarStatus == 80)
					  textProgressBar.setText("Loading 80%");	
				  if (progressBarStatus == 90)
					  textProgressBar.setText("Loading 90%");	
				  if (progressBarStatus == 100)
					  textProgressBar.setText("Loading 100%");	
				}
			  });
			}

			if (progressBarStatus >= 100) {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		  
		               finish();
		                 
		               if (!mIsBackButtonPressed)
		               {
		                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		                    MainActivity.this.startActivity(intent);
		               }
		               		
			}
		  }
	       }).start();

    }
    
    
// file download simulator... a really simple
public int doSomeTasks() {

	while (fileSize <= 1000000) {
		
		fileSize++;

		if (fileSize == 100000) {
			return 10;
		} else if (fileSize == 200000) {
			return 20;
		} else if (fileSize == 300000) {
			return 30;
		}else if (fileSize == 400000) {
			return 40;
		}else if (fileSize == 500000) {
			return 50;
		}else if (fileSize == 600000) {
			return 60;
		}else if (fileSize == 700000) {
			return 70;
		}else if (fileSize == 800000) {
				return 80;
		}else if (fileSize == 900000) {
			return 90;
	}
		
		
		
	}

	return 100;

}


}