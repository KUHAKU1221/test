package com.example.tesuto;

import androidx.annotation.NonNull;

public enum DBEnum {
    URL("jdbc:mysql://192.168.0.1/studentsystem"),
    USER("root"),
    PASSWORD("");

    private String DBData;

    DBEnum(String DBData) {
        this.DBData = DBData;
    }

    public String getDBData() {
        return DBData;
    }
}
