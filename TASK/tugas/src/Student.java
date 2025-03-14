
public class Student extends User{
    public Student(String userName, String userPass){
        super(userName, userPass);
    }

    int scan;
    @Override
    public void login(){
        final String correctUser = "Muhammad Kharisma Aditya Putra";
        final String correctPass = "202410370110200";
        if(getUserName().equals(correctUser) && getUserPass().equals(correctPass)){
            scan = 1;
            displayInfo();
        }else{
            scan = 0;
            displayInfo();
        }

    }

    public void displayInfo(){
        if(scan == 1){
            System.out.println("LOGIN MAHASISWA BERHASIL");
            System.out.println("Nama: " + getUserName());
            System.out.println("NIM: " + getUserPass());
        }else {
            System.err.println("LOGIN ADMIN GAGAL!!");
        }
    }

}
