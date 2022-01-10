package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kessekiitiran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kessekiitiran);
        Button btn6 = findViewById(R.id.button12);
        //ListDAOの起動
        ListDAO dao = new ListDAO(kessekiitiran.this);
        dao.execute();

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //教師の画面に戻る
                finish();

            }
        });
    }
}