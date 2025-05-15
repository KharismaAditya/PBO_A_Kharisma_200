package com.tugasakhir.bookdata.accessible.queryManage;

public class displayQuery {
    String[] connect = {"SELECT * FROM informaticbook","SELECT * FROM machinebook"};
    public String databaseDisplay(int choice){
        return connect[choice];
    }

    public int displayLength(){
        return connect.length;
    }
}
