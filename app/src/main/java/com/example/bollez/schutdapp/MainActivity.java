package com.example.bollez.schutdapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.button;
import static com.example.bollez.schutdapp.R.id.butReadSms;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SmsListener s = new SmsListener();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        Button butReadSms = (Button) findViewById(R.id.butReadSms);
        View v = new View(this);


        butReadSms.setOnClickListener(s.onReceive(context,intent.getAction()));

        //s.onReceive(this,intent);
    }

}
