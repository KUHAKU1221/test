package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TourokuKanryo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touroku_kanryo);

        Button btn80 = findViewById(R.id.button16);
        btn80.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                //教師画面に戻る
                Intent TeacherMenu = new Intent(TourokuKanryo.this,TeacherMenu.class);
                startActivity(TeacherMenu);
            }
        });
    }

}