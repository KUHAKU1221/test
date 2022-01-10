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

public class KessekiKakunin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kessekikakunin);
        //欠席確認画面から修正
        Button btn7 = findViewById(R.id.button8);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //欠席連絡画面に戻る
                finish();
            }
        });
        Intent intent = getIntent();
        //種別の受け取り
        TextView syubetu = findViewById(R.id.textView12);
        syubetu.setText(intent.getStringExtra("syubetu"));
        //日付の受け取り
        TextView date = findViewById(R.id.textView14);
        date.setText(intent.getStringExtra("date"));
        //理由の受け取り
        TextView reason = findViewById(R.id.textView16);
        reason.setText((intent.getStringExtra("reason")));

        Button btn8 = findViewById(R.id.button9);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = getIntent();
                String syubetu = intent.getStringExtra("syubetu");
                String date = intent.getStringExtra("date");
                String reason = intent.getStringExtra("reason");

                InsertDAO dao = new InsertDAO(KessekiKakunin.this);
                dao.execute(syubetu,date,reason);
            }
        });
    }
}
