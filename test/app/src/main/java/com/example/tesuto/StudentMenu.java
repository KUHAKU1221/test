package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);

        TextView textView = findViewById(R.id.textView3);
        LoginObj obj = (LoginObj)this.getApplication();

        textView.setText(obj.getName() + "さん、ようこそ。");

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //欠席連絡画面に移動
                Intent kessekirenraku = new Intent(StudentMenu.this,kessekirenraku.class);
                startActivity(kessekirenraku);
            }
        });
        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                //ログイン画面に移動
                Intent MainActivity = new Intent(StudentMenu.this,MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }

}