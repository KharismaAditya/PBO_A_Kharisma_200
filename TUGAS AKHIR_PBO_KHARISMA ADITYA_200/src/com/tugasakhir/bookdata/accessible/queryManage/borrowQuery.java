package com.tugasakhir.bookdata.accessible.queryManage;

public class borrowQuery {
    String[] select =
            {"SELECT * FROM informaticbook WHERE idbuku = ?",
            "SELECT * FROM machinebook WHERE idbuku = ?"};

    String[] borrow = {"UPDATE informaticbook SET stok = stok - 1 WHERE idbuku = ?",
            "UPDATE machinebook SET stok = stok - 1 WHERE idbuku = ?"};

    public String borrowConnect(int Choice){
        return select[Choice];
    }

    public String queryBorrow(int Choice){
        return borrow[Choice];
    }
}
