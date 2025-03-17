public class Student extends User{
    private String correctUser = "Muhammad Kharisma Aditya Putra";
    private String correctPass = "202410370110200";

    public String getCorrectUser(){
        return  correctUser;
    }

    public String getCorrectPass(){
        return correctPass;
    }
    public Student(String userName, String userPass){
        super(userName, userPass);
    }

    int scan;
    @Override
    public void login(){
        if(getUserName().equals(getCorrectUser()) && getUserPass().equals(getCorrectPass())){
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
            System.err.println("LOGIN MAHASISWA GAGAL!!");
        }
    }

}
