public class Student {
    String nama;
    String NIM;

    void berhasil(){
        System.out.print("\n");
        System.out.println("LOGIN MAHASISWA BERHASIL");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + NIM);
    }

    void gagal(){
        System.out.println("LOGIN GAGAL, Nama atau NIM salah!");
    }

    void login(){
        if(nama.equalsIgnoreCase("Muhammad Kharisma Aditya Putra") && NIM.equalsIgnoreCase("202410370110200")){
            berhasil();
        }else{
            gagal();
        }
    }
}
