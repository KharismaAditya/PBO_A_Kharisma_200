import java.util.Scanner;

public class code {
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
        System.out.print("Masukkan Username: "); String userNama = input.nextLine();
        System.out.print("Masukkan Password: "); String userPass = input.nextLine();
        Admin user1 = new Admin(userNama, userPass);
        user1.login();
        return false;
    }

    private static boolean studentinput(Scanner input){
        System.out.print("Masukkan Nama: "); String userNama = input.nextLine();
        System.out.print("Masukkan NIM anda: "); String userPass = input.nextLine();
        Student user2 = new Student(userNama, userPass);
        user2.login();
        return false;
    }
}
