package com.tugasakhir.bookdata.accessible.readBook;

import java.sql.*;
import com.tugasakhir.bookdata.accessible.databaseConnect;

public class mySql {
    databaseConnect db = new databaseConnect();

    public void displayListBook(){
        try{
            Connection conn = db.getConnection();

            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM buku";
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

    public void pinjamBuku(String idBook){
        try(Connection conn = db.getConnection()){
            String cekStok = "SELECT stok FROM buku WHERE idBuku = ?";
            PreparedStatement cetStmt = conn.prepareStatement(cekStok);
            cetStmt.setString(1, idBook);
            ResultSet rs = cetStmt.executeQuery();

            if(rs.next()){
                int stok = rs.getInt("stok");
                if(stok > 0){
                    String updQuery = "UPDATE buku SET stok = stok - 1 WHERE idbuku = ?";
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
