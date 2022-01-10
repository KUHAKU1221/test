package com.example.tesuto;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertDAO extends AsyncTask<String,Void, Boolean> {
        Connection connection = null;

        Activity activity = null;

        //コンストラクター
    public InsertDAO(Activity act) {
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
    protected Boolean doInBackground(String... insert) {
        open();
        //アプリ全体のデータとしてobjを使う
        LoginObj obj = (LoginObj)activity.getApplication();
        boolean flag = false;
        String sql = "INSERT INTO kesseki_table (syubetu,LoginID,Date,Reason,Detail)"
                 + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, insert[0]);
            statement.setString(2, obj.getId());
            statement.setDate(3, Date.valueOf(insert[1]));
            statement.setString(4, insert[2]);
            statement.setString(5,"");
            int result = statement.executeUpdate();

            if (result != 0) {
                flag = true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close();
        }
        return flag;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        //完了してたら完了画面に行く
        if (aBoolean) {
            //送信完了画面に移動
            Intent sousinkanryou = new Intent(activity, sousinkanryou.class);
            activity.startActivity(sousinkanryou);
        } else {
            //エラー画面に移動

        }
    }
}
