package com.tapathon;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Entry extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        
    }
	
	public void onClickBtn(View view) {
		Intent intent = new Intent(this, TestApp.class);
		
		

		switch (view.getId()) {
			case R.id.btnLvl1:
				intent.putExtra("level", 1);
				intent.putExtra("time", 1500l);
				break;
			
			case R.id.btnLvl2:
				intent.putExtra("level", 2);
				intent.putExtra("time", 1200l);
				break;
				
			case R.id.btnLvl3:
				intent.putExtra("level", 3);
				intent.putExtra("time", 900l);
				break;
				
			case R.id.btnLvl4:
				intent.putExtra("level", 4);
				intent.putExtra("time", 600l);
				break;
				
			case R.id.btnLvl5:
				intent.putExtra("level", 5);
				intent.putExtra("time", 300l);
				break;
			
		}
		startActivity(intent);
	}
}
