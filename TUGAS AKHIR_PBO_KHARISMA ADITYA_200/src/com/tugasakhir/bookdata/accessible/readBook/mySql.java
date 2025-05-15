package com.tugasakhir.bookdata.accessible.readBook;

import java.sql.*;
import com.tugasakhir.bookdata.accessible.databaseConnect;

public class mySql {
    databaseConnect db = new databaseConnect();

    public void displayListBook(String sql){
        try{
            Connection conn = db.getConnection();

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                String judul = rs.getString("judul");
                String penulis = rs.getString("penulis");
                int stok = rs.getInt("stok");
                String bookId = rs.getString("idBuku");

                System.out.println("===============");
                System.out.println("BOOK ID " + bookId);
                System.out.println("JUDUL: " + judul);
                System.out.println("PENULIS: " + penulis);
                System.out.println("STOK: " + stok);
            }

            rs.close();
            statement.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pinjamBuku(String idBook, String selectQuery, String borrowQuary){
        try(Connection conn = db.getConnection()){
            String cekStok = selectQuery;
            PreparedStatement cetStmt = conn.prepareStatement(cekStok);
            cetStmt.setString(1, idBook);
            ResultSet rs = cetStmt.executeQuery();

            if(rs.next()){
                int stok = rs.getInt("stok");
                if(stok > 0){
                    String updQuery = borrowQuary;
                    PreparedStatement updStmt = conn.prepareStatement(updQuery);
                    updStmt.setString(1, idBook);
                    int rowUpd = updStmt.executeUpdate();
                    if(rowUpd > 0){
                        System.out.println("BUKU BERHASIL DIPINJAM");
                    }else {
                        System.out.println("STOK BUKU HABIS");
                    }
                }else {
                    System.out.println("BUKU TIDAK DITEMUKAN");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
