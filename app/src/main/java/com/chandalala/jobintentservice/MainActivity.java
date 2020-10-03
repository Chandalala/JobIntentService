package com.chandalala.jobintentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*
    * JobIntentService
    * combines two services, intent service and jobservice
    * */

    private EditText editTextInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.edit_text_input);


    }

    public void enqueueWork(View view) {
        String input = editTextInput.getText().toString();

        Intent intent = new Intent(this, ExampleJobIntentService.class);
        intent.putExtra("inputExtra", input);

        ExampleJobIntentService.enqueueWork(this, intent);

    }
}
