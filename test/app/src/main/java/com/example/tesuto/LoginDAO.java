package com.example.tesuto;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends AsyncTask<String,Void, LoginObj> {
    Connection connection = null;
    Activity activity = null;

    //コンストラクター
    public LoginDAO(Activity act) {
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
    protected LoginObj doInBackground(String... login) {
        open();
        //アプリ全体のデータとしてobjを使う
        LoginObj obj = (LoginObj)activity.getApplication();

        String sql = "SELECT * FROM login_table where LoginID = ? and password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login[0]);
            statement.setString(2, login[1]);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                //objの中にログインIDとnameとFlagを入れる
                obj.setId(result.getString("loginid"));
                obj.setName(result.getString("name"));
                obj.setFlag(result.getInt("flag"));
            }

        }catch(SQLException e){
                e.printStackTrace();
        }finally{
            close();
            //objを返す
            return obj;
        }
    }

    @Override
    protected void onPostExecute(LoginObj obj){
        if(!obj.getId().isEmpty()) {
            Intent menuIntent ;
            if(obj.getFlag() == 0) {
                menuIntent = new Intent(activity, StudentMenu.class);
            }else{
                menuIntent = new Intent(activity,TeacherMenu.class);
            }
            activity.startActivity(menuIntent);
        }else{
        }
    }
}
