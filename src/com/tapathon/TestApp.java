package com.tapathon;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestApp extends Activity {
	
	Random rand = new Random();
	private  Button tapBtn;
	private long waitTimeMillis;
	int count =0;
	int tempCount = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
			tapBtn = (Button) findViewById(R.id.class.getField("button"+(rand.nextInt(39)+1)).getInt(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		tapBtn.setVisibility(View.VISIBLE);
		
		waitTimeMillis = getIntent().getLongExtra("time", 2000l);
		((TextView)findViewById(R.id.textView2)).setText("Level: "+getIntent().getIntExtra("level", 1));
		       
      new Thread(new RunnableProcess()).start();

      
    }
    
    
    public void showRandomButton() throws Exception{
    	tapBtn.setVisibility(View.INVISIBLE); 
    	tempCount = 0;
		tapBtn = (Button) findViewById(R.id.class.getField("button"+(rand.nextInt(39)+1)).getInt(null));
		tapBtn.setVisibility(View.VISIBLE);
    }
    
    public void onBtnClick(View view) {
    	if(view.getVisibility() == View.VISIBLE){
    		tempCount++;
    		if(tempCount == 1){
    			count++;
        		((TextView)findViewById(R.id.textView1)).setText(Integer.toString(count));
    		}
    	}
    }
    
    class RunnableProcess implements Runnable{

		@Override
		public void run() {
			long startTime = System.currentTimeMillis();
			 while(System.currentTimeMillis()-startTime < 30000){
				 tapBtn.post(new Runnable() {
		                public void run() {
		                	try {
				        		showRandomButton();
					   		} catch (Exception e) {
					   			e.printStackTrace();
					   		}
		                }
		            });

			   		try {
						Thread.sleep(waitTimeMillis);
					} catch (InterruptedException e) {
						
					}
		        }
			 
			 tapBtn.post(new Runnable() {
	                public void run() {
	                	tapBtn.setVisibility(View.INVISIBLE); 
	                	((TextView)findViewById(R.id.textView1)).setText(Integer.toString(count)+ "  GAME OVER!");
	                }
	            });
			
		}
    	
    }
}