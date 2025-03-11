
public class Student {
    String nama;
    String NIM;

    Student(String inama, String ipass){
        this.nama = inama;
        this.NIM = ipass;
    }
    void berhasil(){
        System.out.print("\n");
        System.out.println("LOGIN MAHASISWA BERHASIL");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + NIM);
    }

    void gagal(){
        System.err.println("LOGIN GAGAL, Nama atau NIM salah!");
    }

    void login(){
        final String studentpass = "Muhammad Kharisma Aditya Putra";
        final String nimpass = "202410370110200";
        if(nama.equalsIgnoreCase(studentpass) && NIM.equalsIgnoreCase(nimpass)){
            berhasil();
        }else{
            gagal();
        }
    }
}
