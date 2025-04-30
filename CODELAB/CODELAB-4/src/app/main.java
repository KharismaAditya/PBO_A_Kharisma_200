package app;
import perpustakaan.*;

public class main {
    public static void main(String[] args){
        buku buku1 = new nonfiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        buku buku2 = new fiksi("I Have No Mouth and I Must Scream", "Harlan Ellison", "Novel");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        anggota Anggota1 = new anggota("Kharisma Aditya", "A200");
        anggota Anggota2 = new anggota("Diandra", "A024");

        Anggota1.tampilAnggota();
        Anggota2.tampilAnggota();
        System.out.println();

        Anggota1.pinjamBuku(buku1);
        Anggota2.pinjamBuku(buku2, 7);
        System.out.println();

        Anggota1.kembalikanBuku(buku1);
        Anggota2.kembalikanBuku(buku2);
    }

}
