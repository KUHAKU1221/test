package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class error extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        Button btn81 = findViewById(R.id.button14);
        btn81.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                //前の画面に戻る
                finish();
            }
        });
    }
}