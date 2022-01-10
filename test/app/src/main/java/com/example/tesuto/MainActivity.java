package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttonを取得
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText text1 = findViewById(R.id.text1);
                EditText text2 = findViewById(R.id.text2);
                text1.setText("");
                text2.setText("");


            }
        });
        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                EditText text1 = findViewById(R.id.text1);
                EditText text2 = findViewById(R.id.text2);
                LoginDAO dao = new LoginDAO(MainActivity.this);
                dao.execute(text1.getText().toString(),text2.getText().toString());
            }
        });
    }
}