package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    // A constant to use as a key for Intents
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(getApplicationContext());
            }
        });
    }

    public void sendMessage(Context view) {
//         creating a new Intent, the current context and the activity to which the intent is supplied
//         are taken as parameters
        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        An identifier is created to reference the editable text field
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
//        The value of the text field is taken and stored in the message
        String message = editText.getText().toString();
//        The variable is then passed to the Intent to carry it to the next activity
        intent.putExtra(EXTRA_MESSAGE, message);
//        The new activity is started with the intent
        startActivity(intent);
    }
}