package com.example.tesuto;

import android.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewTourokuDAO extends AsyncTask<String,Void,Boolean>{
    Connection connection = null;
    Activity activity = null;

    //コンストラクター
    public NewTourokuDAO(Activity act) {
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
        String sql = "INSERT INTO login_table(LoginID,Password,Name,Class,Flag)"
                + "VALUES(?,?,?,?,?)";
        boolean flag = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, insert[0]);
            statement.setString(2, insert[1]);
            statement.setString(3, insert[2]);
            statement.setString(4, insert[3]);
            statement.setInt(5,Integer.parseInt(insert[4]));
            int result = statement.executeUpdate();
            if(result != 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return flag;
    }
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        //完了してたら登録完了画面に移動
        if(aBoolean){
            Intent TourokuKanryo = new Intent(activity, TourokuKanryo.class);
            activity.startActivity(TourokuKanryo);
        }else{
            //エラー画面に移動

        }
    }
}
