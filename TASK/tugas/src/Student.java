
public class Student {
    String nama;
    String NIM;

    Student(String iNama, String iPass){
        this.nama = iNama;
        this.NIM = iPass;
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
        final String studentPass = "Muhammad Kharisma Aditya Putra";
        final String nimPass = "202410370110200";
        if(nama.equalsIgnoreCase(studentPass) && NIM.equalsIgnoreCase(nimPass)){
            berhasil();
        }else{
            gagal();
        }
    }
}
