package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sousinkanryou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousinkanryou);
        Button btn11 = findViewById(R.id.button10);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //生徒の画面に移動
                Intent StudentMenu = new Intent(sousinkanryou.this,StudentMenu.class);
                startActivity(StudentMenu);
            }
        });
    }
}