import java.util.Scanner;
import java.time.LocalDateTime;

public class Code {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LocalDateTime timenow = LocalDateTime.now();

        String nama;
        String kelamin;
        int tahunlahir;

        System.out.print("Masukkan nama: ");nama = input.nextLine();
        System.out.print("Masukkan jenis kelamin (P/L): "); kelamin = input.nextLine();
        System.out.print("Masukkan umur: ");tahunlahir = input.nextInt();

        if(kelamin.equalsIgnoreCase("p")){
            kelamin = "Perempuan";
        } else if (kelamin.equalsIgnoreCase("l")) {
            kelamin = "Laki-laki";
        }else{
            System.err.println("KELAMIN TIDAK DITEMUKAM. HARAP MASUKKAN KODE YANG BENAR");
            kelamin = "ERROR";
        }

        int umur = timenow.getYear() - tahunlahir;


        System.out.println("Data diri: ");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis kelamin : " + kelamin);
        System.out.println("Umur          : " + umur + " Tahun");
    }

}
