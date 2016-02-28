package com.example.statechange;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StateChangeActivity extends Activity {

	private static final String TAG = "com.example.StateChange";
	private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_change);
        Log.i(TAG, "onCreate");
		//get a reference for our save button from xml
		Button saveButton = (Button) findViewById(R.id.saveButton);
		//get a reference to our editText from xml
		final EditText editName = (EditText) findViewById(R.id.editName);
		final TextView textView = (TextView) findViewById(R.id.name);


		if (savedInstanceState!=null)
		{
			String str = savedInstanceState.getString("savedName");
			if (str!=null) //not null, so something was saved
				name = str;
			//we need to set the text field
			//try to comment the above line out and
			//see the effect after orientation change (after saving some name)
		}
		//initialize our text field
        textView.setText("Saved Name:"+name);

		//add a click listener to our save button
		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//change our name variable to the input from the
				//user
				name = editName.getText().toString();
				//set the new value in the text field
				textView.setText("Saved Name: "+name);
			}
		});
    }

	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart");
	}
	
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}
	
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause");
	}
	
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop");
	}
	
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart");
	}

	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}

	//This method is called before our activity is destroyed
	protected void onSaveInstanceState(Bundle outState) {
		//ALWAYS CALL THE SUPER METHOD
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState");
		/* Here we put code now to save the state */
		outState.putString("savedName", name);
		
	}
	//this is called when our activity is recreated, but
	//AFTER our onCreate method has been called
	//EXTREMELY IMPORTANT DETAIL
	//This is an alternative place to restore the data
	//This can also be done in the onCreate method like in the book.
	protected void onRestoreInstanceState(Bundle savedState) {
		//MOST UI elements will automatically store the information
		//if we call the super.onRestoreInstaceState
		//but other data will be lost.
		super.onRestoreInstanceState(savedState);
		Log.i(TAG, "onRestoreInstanceState");
		/*Here we restore any state */
		TextView savedName = (TextView) findViewById(R.id.name);
		//in the line below, notice key value matches the key from onSaved
		//this is of course EXTREMELY IMPORTANT
		this.name = savedState.getString("savedName");

		//since this method is called AFTER onCreate
		//we need to set the text field
		//try to comment the line out and
		//see the effect after orientation change (after saving some name)
		//savedName.setText("Saved Name:"+name);

	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.state_change, menu);
        return true;
    }
    
}
