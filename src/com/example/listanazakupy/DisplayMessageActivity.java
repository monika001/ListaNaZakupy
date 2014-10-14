package com.example.listanazakupy;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		
		
		     //allow to display on another activitie's layout the name of the list (message)
		     // create a text view:
            // TextView textView = new TextView(this);
			// textView.setTextSize(15);
			// textView.setText(message);
		
	     	          // Set the text view as the activity layout
			// setContentView(textView);
			
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	*/
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		//get a message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		//message as a title in the action bar
		//if the user doesn't put the name of a list, the default name 
		//in action bar will be the name of app
		if (message.equals("")){
			getActionBar().setTitle("Lista na zakupy");
		}
		else{
			getActionBar().setTitle(message);
		}
			
				
	    
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    // getMenuInflater().inflate(R.menu.main_activity_action, menu);
		// return super.onCreateOptionsMenu(menu);
		MenuInflater mif = getMenuInflater();
		mif.inflate(R.menu.main_activity_action, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	
 
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
