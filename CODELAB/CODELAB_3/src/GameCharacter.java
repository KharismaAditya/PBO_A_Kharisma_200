public class GameCharacter {
    private String agentName;
    private int agentHealth;

    //this is a Constuctor for GameCharacter class that have 2 parameters (Name and Health)
    public GameCharacter(String agentName, int agentHealth){
        this.agentName = agentName; //this.* is for fill the Attribute of agentName with parameter Name
        this.agentHealth = agentHealth;
    }

    public String getName(){
        return agentName; //getter is for take the Value of agentName, whenever you want to call the value of agentName, you can use getName
    }

    public int getHealth(){
        return agentHealth;
    }

    public void setName(String name){
        this.agentName = name;
    }

    public void setHealth(int health){
        this.agentHealth = health; //setter is to set the value of agentHealth, whenever you want to change the value of agentName, you can use setHealth
    }

    public void info(){
        System.out.println(agentName);
        System.out.println("HP: " + agentHealth);
    }

    public void attack(GameCharacter target){
        System.out.println(agentName + " Menyerang " + target.getName());
        System.out.println(" ");
    }
}
