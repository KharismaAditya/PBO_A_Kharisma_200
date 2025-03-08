public class Main {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.accountNumber = "202410370110200";
        account1.ownerName = "Kharisma Aditya";
        account1.balance = 50000;

        account2.accountNumber = "202410370110039";
        account2.ownerName = "Firdaus";
        account2.balance = 40000;

        account1.displayinfo();
        account2.displayinfo();

        System.out.print("\n");
        account1.depositinfo(20000);
        account2.depositinfo(10000);

        System.out.print("\n");
        account1.withdrawMoney(80000);
        account2.withdrawMoney(30000);
    }
}
