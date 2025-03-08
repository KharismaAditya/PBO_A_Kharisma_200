public class BankAccount {
    String accountNumber;
    String ownerName;
    double balance;

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

    String periksa(double ammount,double balance){
        if(ammount > balance){
            return "(GAGAL, Saldo tidak mencukupi)";
        }
        return  "(Berhasil)";
    }

    double tariktunai(double ammount, double balance){
        if(ammount > balance){
            return balance;
        }
        return balance - ammount;
    }

    void withdrawMoney(double ammount){
        System.out.println(ownerName + " Menarik RP" + ammount + periksa(ammount, balance) + " Saldo sekarang: Rp" +tariktunai(ammount, balance));

    }
}
