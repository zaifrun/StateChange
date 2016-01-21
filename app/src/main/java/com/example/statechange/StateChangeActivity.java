package com.example.statechange;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class StateChangeActivity extends Activity {

	private static final String TAG = "com.example.StateChange";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_change);
        Log.i(TAG, "onCreate");
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

	protected void onSaveInstanceState(Bundle outState) {
		//ALWAYS CALL THE SUPER METHOD
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState");
		/* Here we put code now to save the state of the edit text */
		EditText edit = (EditText) findViewById(R.id.editText1);
		
		outState.putString("edittext", edit.getText().toString());
		
	}
	
	protected void onRestoreInstanceState(Bundle savedState) {
		//MOST UI elements will automatically store the information
		//if we call the super.onRestoreInstaceState
		//but other data will be lost.
		super.onRestoreInstanceState(savedState);
		Log.i(TAG, "onRestoreInstanceState");
		/*Here we restore any state */
		EditText edit = (EditText) findViewById(R.id.editText1);
		//in the line below, notice key value matches the key from onSaved
		String text = savedState.getString("edittext"); 
		//edit.setText(text); //try to leave this line out and see what happens?
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.state_change, menu);
        return true;
    }
    
}
