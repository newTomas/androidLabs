package com.example.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);
        textView.setText("Лабораторная работа № 3. Работу выполнил Радионов В.В. 803в2");
        setContentView(textView);
    }
}