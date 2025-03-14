public class Hero extends GameCharacter{
    private int agentDamage;

    public Hero(String agentName, int agentHealth, int Damage){
        super(agentName, agentHealth);
        this.agentDamage = Damage;
    }

    public int getAgentDamage(){
        return agentDamage;
    }

    @Override
    public void attack(GameCharacter target){
        System.out.println(getName() + " attacks " + target.getName() + " using Orbital Strike!");
        target.setHealth(target.getHealth() - getAgentDamage());
        target.info();
    }

    public void info(){
        System.out.println(getName() + " has health: " + getHealth());
    }
}
