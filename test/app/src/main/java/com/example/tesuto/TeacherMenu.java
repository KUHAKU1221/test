package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_menu);

        TextView textView = findViewById(R.id.textView4);
        LoginObj obj = (LoginObj)this.getApplication();

        textView.setText(obj.getName() + "さん、ようこそ。");
        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //欠席一覧の画面に移動
                Intent kessekiitiran = new Intent(TeacherMenu.this,kessekiitiran.class);
                startActivity(kessekiitiran);
            }
        });
        Button btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                //ログイン画面に移動
                finish();
            }
        });
        Button btn6 = findViewById(R.id.button18);
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                Intent touroku = new Intent(TeacherMenu.this,touroku.class);
                startActivity(touroku);
            }
        });
    }
}