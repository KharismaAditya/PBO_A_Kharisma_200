package com.tugasakhir.bookdata.accessible.queryManage;

public class addQuery {
    String[] add =
            {"INSERT INTO informaticbook (judul, penulis, stok, idBuku) VALUES (?, ?, ?, ?)",
                    "INSERT INTO machinebook (judul, penulis, stok, idBuku) VALUES (?, ?, ?, ?)"};

    public String addConnect(int Choice){
        return add[Choice];
    }
}
