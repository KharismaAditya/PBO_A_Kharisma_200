import java.util.Scanner;

public class code {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("Pilih login: ");
            System.out.println("1. Admin\n2. Mahasiswa");
            System.out.print("Masukkan pilihan: ");String pilih = input.next();
            switch (pilih){
                case "1":
                    admin(input);
                    break;
                case "2":
                    logmhs(input);
                    break;
                default:
                    System.out.println("INPUT YANG ANDA MASUKKAN TIDAK VALID");
            }
            System.out.print("ingin melanjutkan?(y/n) : "); pilih = input.next();
            if(pilih.equalsIgnoreCase("n")){
                loop = false;
            }
        }
        System.out.println("TERIMA KASIH TELAH MENGGUNAKAN PROGRAM INI");

    }

    private static void admin(Scanner input){
        input.nextLine();
        System.out.println("Login page admin");
        System.out.print("Masukkan Username: ");String admin = input.nextLine();
        System.out.print("Masukkan Password: "); String pass = input.nextLine();

        if(admin.equals("Admin200") && pass.equals("Password200")){
            System.out.println("Login admin berhasil");
        }else{
            System.err.println("Login gagal, Username atau password salah!!");
        }
    }

    private static void logmhs(Scanner input){
        input.nextLine();
        String nb = "Muhammad Kharisma Aditya Putra";
        String nimb = "202410370110200";

        System.out.println("Login Mahasiswa");
        System.out.print("Masukkan Nama: "); String nama = input.nextLine();
        System.out.print("Masukkan NIM: "); String nim = input.nextLine();

        if(nama.equals(nb) && nim.equals(nimb)){
            System.out.println("Login Mahasiswa berhasil");
            System.out.println("Nama: " + nama);
            System.out.println("NIM : " + nim);
        }else{
            System.err.println("Login gagal, Nama atau NIM salah!");
        }
    }
}
