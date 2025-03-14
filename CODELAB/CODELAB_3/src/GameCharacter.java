public class GameCharacter {
    private String agentName;
    private int agentHealth;

    public GameCharacter(String agentName, int agentHealth){
        this.agentName = agentName;
        this.agentHealth = agentHealth;
    }

    public String getName(){
        return agentName;
    }

    public int getHealth(){
        return agentHealth;
    }

    public void setName(String name){
        this.agentName = name;
    }

    public void setHealth(int health){
        this.agentHealth = health;
    }

    public void info(){
        System.out.println(agentName);
        System.out.println("HP: " + agentHealth);
    }

    public void attack(GameCharacter target){
        System.out.println(agentName + "Menyerang" + target.getName());
    }
}
