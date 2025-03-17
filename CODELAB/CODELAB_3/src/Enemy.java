public class Enemy extends GameCharacter{
    private int agentDamage;

    public Enemy(String agentName, int agentHealth, int Damage){
        super(agentName, agentHealth);
        this.agentDamage = Damage;
    }

    public int getAgentDamage(){
        return agentDamage;
    }

    @Override
    public void attack(GameCharacter target){
        System.out.println(getName() + " attacks " + target.getName() + " using Snake bite!");
        target.setHealth(target.getHealth() - getAgentDamage());
        setName("Viper1");
        target.info();
    }

    public void info(){
        System.out.println(getName() + " has health: " + getHealth());
    }
}
