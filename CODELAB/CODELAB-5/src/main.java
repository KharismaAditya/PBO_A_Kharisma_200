import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        program manage = new program();

        while (loop){
            System.out.println();
            System.out.println("===== MENU MANAJEMEN STOK =====");
            System.out.println("1. Tambah Barang Baru\n2. Tampilkan Semua Barang\n3. Kurangi Stok Barang\n4. Keluar");
            System.out.print("PIlih opsi: ");
            int choice;
            try{
                choice = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("INPUT HARUS BERUPA ANGKA");
                input.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    System.out.println();
                    System.out.print("Masukkan nama barang: "); String namaBarang = input.next();
                    System.out.print("Masukkan stok awal barang: "); int stokBarang = input.nextInt();
                    manage.tambahBarang(daftarBarang, namaBarang, stokBarang);
                    break;
                case 2:
                    manage.tampilBarang(daftarBarang);
                    break;
                case 3:
                    System.out.println();
                    if(daftarBarang.isEmpty()){
                        System.out.println("Tidak ada barang untuk dikurangi stok");
                        break;
                    }
                    System.out.println("Pilih barang: ");
                    manage.tampilBarang(daftarBarang);
                    try {
                        System.out.print("Masukkan indeks barang: ");int index = input.nextInt();
                        input.nextLine();
                        if(index < 0 || index >= daftarBarang.size()){
                            System.out.println("Indeks tidak valid");
                            break;
                        }
                        manage.kurangStok(daftarBarang, index);
                    }catch (InputMismatchException e){
                        System.out.println("Input harus berupa Angka!");
                        input.nextLine();
                    }catch (StokTIdakCukupException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    loop = false;
                    System.out.println("KELUAR DARI PROGRAM");
                    break;
                default:
                    System.out.println("OPSI TIDAK DIKENALI");
            }
        }
    }
}
