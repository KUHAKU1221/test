package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class touroku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touroku);

        Button btn19 = findViewById(R.id.button15);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btn20 = findViewById(R.id.button13);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ラジオグループの取得
                RadioGroup rg1 = findViewById(R.id.radiobuttongroup);
                //ラジオグループ内のチェックされてるものを持ってくる
                int id1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = findViewById(id1);

                Intent TourokuKakunin = new Intent(touroku.this,TourokuKakunin.class);
                //ログインIDいれる
                EditText tv1 = findViewById(R.id.editTextTextPersonName);
                TourokuKakunin.putExtra("LoginID",String.valueOf(tv1.getText()));
                //パスワードいれる
                EditText tv = findViewById(R.id.editTextTextPersonName2);
                TourokuKakunin.putExtra("Password", String.valueOf(tv.getText()));
                //名前入れる
                EditText tv2 = findViewById(R.id.editTextTextPersonName4);
                TourokuKakunin.putExtra("Name", String.valueOf(tv2.getText()));
                //クラスを入れる
                EditText tv3 = findViewById(R.id.editTextTextPersonName3);
                TourokuKakunin.putExtra("Class", String.valueOf(tv3.getText()));
                //flagを入れる

                TourokuKakunin.putExtra("Flag", rb1.getText());
                //登録確認に移動

                startActivity(TourokuKakunin);
            }
        });

    }
}