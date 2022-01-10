package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;

public class TourokuKakunin extends AppCompatActivity {


    public static void putExtra(String loginID, CharSequence text) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touroku_kakunin);
        //登録画面からの修正
        Button btn21 = findViewById(R.id.button17);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新規登録画面に戻る
                finish();
            }
        });
        Intent intent = getIntent();
        //ユーザID取得
        TextView LoginID = findViewById(R.id.textView31);
        LoginID.setText(intent.getStringExtra("LoginID"));
        //パスワードの受け取り
        TextView Password = findViewById(R.id.textView33);
        Password.setText(intent.getStringExtra("Password"));
        //名前の受け取り
        TextView Name = findViewById(R.id.textView35);
        Name.setText(intent.getStringExtra("Name"));
        //クラスの受け取り
        TextView Class = findViewById(R.id.textView37);
        Class.setText(intent.getStringExtra("Class"));
        //Flagの受け取り
        TextView Flag = findViewById(R.id.textView39);
        Flag.setText(intent.getStringExtra("Flag"));
        //登録確認画面から確定
        Button btn23 = findViewById(R.id.button11);
        btn23.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View V) {
            Intent intent = getIntent();
            String LoginID = intent.getStringExtra("LoginID");
            String Password = intent.getStringExtra("Password");
            String Name= intent.getStringExtra("Name");
            String Class = intent.getStringExtra("Class");
            String Flag = intent.getStringExtra("Flag");

            if(Flag.equals("学生")){
                Flag = "0";
            }else{
                Flag = "1";
            }

            NewTourokuDAO dao = new NewTourokuDAO(TourokuKakunin.this);
            dao.execute(LoginID,Password,Name,Class,Flag);
        }
    });
    }
}