package com.example.tesuto;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ListDAO extends AsyncTask<Void,Void, ArrayList<Map<String,String>>> {
    Connection connection = null;
    Activity activity = null;

    //コンストラクター
    public ListDAO(Activity act) {
        activity = act;
    }

    //DB接続準備
    public void open() {
        try {
            connection = DriverManager.getConnection(DBEnum.URL.getDBData(),
                    DBEnum.USER.getDBData(), DBEnum.PASSWORD.getDBData());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //DB切断処理
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected ArrayList<Map<String,String>> doInBackground(Void ...aVoid) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String sql = "SELECT * FROM kesseki_table ,login_table where login_table.LoginID = kesseki_table.LoginID AND kesseki_table.date = ?";
        open();
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, Date.valueOf(format.format(cal.getTime())));
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                //Mapの中にデータを入れる
                Map<String, String> map = new HashMap<>();
                map.put("id", result.getString("loginid"));
                map.put("syubetu", result.getString("syubetu"));
                map.put("name", result.getString("name"));
                map.put("reason", result.getString("reason"));
                //データをArrayListに格納
                arrayList.add(map);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return arrayList;
    }

    @Override
    protected void onPostExecute(ArrayList<Map<String, String>> arrayList) {
        //データのセット
        SimpleAdapter adapter = new SimpleAdapter(activity,arrayList,
                R.layout.raw,new String[]{"name","syubetu","reason"},
                new int[] {R.id.textView1,R.id.textView2,R.id.textView3});
        //ListViewを持ってくる。
        ListView listView = activity.findViewById(R.id.listView1);
        listView.setAdapter(adapter);
    }
}
