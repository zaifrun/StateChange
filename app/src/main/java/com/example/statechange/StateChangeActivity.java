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
        Log.d(TAG, "onCreate");
		//get a reference for our save button from xml
		Button saveButton = findViewById(R.id.saveButton);
		final EditText editName = findViewById(R.id.editName);

		//do we have some saved state?
		if (savedInstanceState!=null)
			{
				String saved = savedInstanceState.getString("savedName");
				if (saved!=null) //did we save something
					name = saved;

			}

		//initialize our text field
		final TextView textView = findViewById(R.id.name);
        textView.setText("Saved Name:"+name);

		//add a click listener to our save button
		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//change our name variable to the input from the user
				name = editName.getText().toString();
				//set the new value in the text field
				textView.setText("Saved Name: "+name);
			}
		});
    }

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}

	//This method is called before our activity is destroyed
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		//ALWAYS CALL THE SUPER METHOD - To be nice!
		super.onSaveInstanceState(outState);
		Log.d(TAG, "onSaveInstanceState");
		/* Here we put code now to save the state */
		outState.putString("savedName", name);

	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.state_change, menu);
        return true;
    }
    
}
