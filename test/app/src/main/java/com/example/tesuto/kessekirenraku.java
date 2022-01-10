package com.example.tesuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class kessekirenraku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kessekirenraku);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        TextView date = findViewById(R.id.textView30);
        date.setText(format.format(cal.getTime()));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("病院");
        adapter.add("電車の遅延");
        adapter.add("バスの遅延");
        adapter.add("路面バスの遅延");
        adapter.add("寝坊");
        adapter.add("体調不良");

        //SpinnerにAdapterをセット
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        //Spinnerの選択イベントを取得
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button btn9 = findViewById(R.id.button6);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //生徒の画面に移動
                Intent StudentMenu = new Intent(kessekirenraku.this,StudentMenu.class);
                startActivity(StudentMenu);
            }
        });
        Button btn10 = findViewById(R.id.button7);
        btn10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                //欠席確認画面に移動
                //ラジオグループの取得
                RadioGroup rg1 = findViewById(R.id.radiogroup);
                //ラジオグループ内のチェックされてるものを持ってくる
                int id1 = rg1.getCheckedRadioButtonId();
                RadioButton rb = findViewById(id1);

                Intent KessekiKakunin = new Intent(kessekirenraku.this,KessekiKakunin.class);
                //種別いれる
                KessekiKakunin.putExtra("syubetu",rb.getText());
                //日付いれる
                TextView tv = findViewById(R.id.textView30);
                KessekiKakunin.putExtra("date",tv.getText());
                //理由を入れる
                Spinner sp1 = findViewById(R.id.spinner);
                KessekiKakunin.putExtra("reason",(String )sp1.getSelectedItem());

                startActivity(KessekiKakunin);
            }
        });
    }
}