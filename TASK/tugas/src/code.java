import java.util.Scanner;

public class code {
    static  Admin user1 = new Admin();
    static  Student user2 = new Student();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("Pilih login: ");
            System.out.println("1. Admin\n2. Mahasiswa");
            System.out.print("Masukkan pilihan: ");String pilih = input.next();

            input.nextLine();

            switch (pilih){
                case "1":
                    loop = admininput(input);
                    break;
                case "2":
                    loop = studentinput(input);
                    break;
                default:
                    System.out.println("INPUT YANG ANDA MASUKKAN TIDAK VALID, Harap masukkan Input yang benar!!");
                    System.out.print("\n");
            }
        }
        input.close();
    }

    private static boolean admininput(Scanner input){
        System.out.print("Masukkan Username: ");
        user1.nama = input.nextLine();
        System.out.print("Masukkan Password: ");
        user1.password = input.nextLine();
        user1.login();

        return false;
    }

    private static boolean studentinput(Scanner input){
        System.out.print("Masukkan Nama: ");
        user2.nama = input.nextLine();
        System.out.print("Masukkan NIM anda: ");
        user2.NIM = input.nextLine();
        user2.login();

        return false;
    }
}
