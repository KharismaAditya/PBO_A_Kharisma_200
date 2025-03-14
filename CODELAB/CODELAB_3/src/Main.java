public class Main {
    public static void main(String[] args){
        GameCharacter general = new GameCharacter("General Character", 100);
        Hero defender = new Hero("Brimstone", 150, 20);
        Enemy attacker = new Enemy("Viper", 200, 15);

        defender.info();
        attacker.info();
        defender.attack(attacker);
        defender.attack(attacker);
        attacker.attack(defender);
    }


}
