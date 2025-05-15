package com.tugasakhir.bookdata.accessible.queryManage;

public class deleteQuery {
    String[] delete =
            {"DELETE FROM informaticbook WHERE idBuku = ?",
                    "DELETE FROM machinebook WHERE idBuku = ?"};

    public String deleteConnect(int Choice){
        return delete[Choice];
    }
}
