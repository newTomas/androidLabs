package com.example.labs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    String name = "";
    final static String nameVariableKey = "NAME_VAR";
    final static String textViewTexKey = "TEXT_VIEW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        outState.putString(nameVariableKey, name);
        TextView textView = findViewById(R.id.textOutput);
        outState.putString(textViewTexKey, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(nameVariableKey);
        String textViewText = savedInstanceState.getString(textViewTexKey);
        TextView dataView = findViewById(R.id.textOutput);
        dataView.setText(textViewText);
    }

    public void saveField(View view){
        TextView input = findViewById(R.id.textInput);
        name = input.getText().toString();
    }

    public void restoreField(View view){
        TextView output = findViewById(R.id.textOutput);
        output.setText(name);
    }
}