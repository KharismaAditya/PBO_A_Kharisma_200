public class BankAccount {
    String accountNumber;
    String ownerName;
    double balance;

    BankAccount(String aN, String oN, double bL){
        this.accountNumber = aN;
        this.ownerName = oN;
        this.balance = bL;
    }

    void displayinfo(){
        System.out.println("Nomor Rekening: " + accountNumber);
        System.out.println("Nama Pemilik: " + ownerName);
        System.out.println("Saldo: Rp" + balance);
        System.out.print("\n");
    }

    void depositinfo(double ammount){
        balance += ammount;
        System.out.println(ownerName + " menyetor Rp" + ammount + ". Saldo sekarang: Rp" + balance);
    }


    void withdrawMoney(double ammount){
        if(ammount > balance){
            System.out.println(ownerName + " mencoba menarik Rp" + ammount + " (GAGAL, saldo tidak mencukupi), Saldo sekarang: Rp" + balance);
        }else{
            balance -= ammount;
            System.out.println(ownerName + " menarik Rp" + ammount + " (BERHASIL), Saldo sekarang: Rp" + balance);
        }
    }
}
