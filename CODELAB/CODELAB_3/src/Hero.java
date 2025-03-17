public class Hero extends GameCharacter{
    private int agentDamage;

    public Hero(String agentName, int agentHealth, int Damage){
        super(agentName, agentHealth); //super is for calling the attributes from parent class like agentName and agentHealth
        this.agentDamage = Damage;
    }

    public int getAgentDamage(){
        return agentDamage;
    }

    @Override //override is for overriding your method so that the methode from Parent class and Sub-class is different
    public void attack(GameCharacter target){
        System.out.println(getName() + " attacks " + target.getName() + " using Orbital Strike!"); //using getName to show the value "agentName"
        target.setHealth(target.getHealth() - getAgentDamage()); //using setHealth to change the Value of target Health
        setName("Brimstone1");
        target.info();
    }

    public void info(){
        System.out.println(getName() + " has health: " + getHealth());
    }
}
