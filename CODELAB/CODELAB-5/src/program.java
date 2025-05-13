import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class program {
    Scanner input = new Scanner(System.in);

    public void tambahBarang(ArrayList<Barang> daftarBarang,String nama, int Stok){
        try {
            daftarBarang.add(new Barang(nama,Stok));
            System.out.println("Input Stok berhasil ditambahkan");
        }catch (InputMismatchException e){
            System.out.println("Input harus berupa Angka");
            input.nextLine();
        }
    }

    public void tampilBarang(ArrayList<Barang> daftarBarang){
        if(daftarBarang.isEmpty()){
            System.out.println("Stok Barang Kosong");
        }else{;
            System.out.println();
            System.out.println("DAFTAR BARANG: ");
            for(int i = 0; i < daftarBarang.size(); i++){
                Barang barang = daftarBarang.get(i);
                System.out.println(i + ". " + barang.getNama() + " - Stok: " + barang.getStok());
            }
        }
    }

    public void kurangStok(ArrayList<Barang> daftarBarang, int index){
        System.out.print("Masukkan jumlah barang yang ingin dikurangi: "); int jumlah = input.nextInt();
        input.nextLine();
        Barang barangDipilih = daftarBarang.get(index);
        barangDipilih.kurangiStok(jumlah);
        System.out.println("Stok berhasil dikurangi");
    }
}
