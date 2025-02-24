import java.util.Scanner;

public class Code {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String nama;
        String kelamin;
        int umur;

        System.out.print("Masukkan nama: ");nama = input.nextLine();
        System.out.print("Masukkan jenis kelamin (P/L): "); kelamin = input.nextLine();
        System.out.print("Masukkan umur: ");umur = input.nextInt();

        if(kelamin.equalsIgnoreCase("p")){
            kelamin = "Perempuan";
        } else if (kelamin.equalsIgnoreCase("l")) {
            kelamin = "Laki-laki";
        }else{
            System.err.println("KELAMIN TIDAK DITEMUKAM. HARAP MASUKKAN KODE YANG BENAR");
            kelamin = "ERROR";
        }

        System.out.println("Data diri: ");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis kelamin : " + kelamin);
        System.out.println("Umur          : " + umur + " Tahun");
    }

}
