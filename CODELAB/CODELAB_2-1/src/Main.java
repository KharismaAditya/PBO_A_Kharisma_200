public class Main {
    public static void main(String[] args){
        Anima animal1 = new Anima();
        Anima animal2 = new  Anima();

        animal1.name = "Cat";
        animal1.type = "Mammal";
        animal1.sound = "Nyann~~";

        animal2.name = "Dog";
        animal2.type = "Mammal";
        animal2.sound = "Woof-Woof!!";

        animal1.talk();
        animal2.talk();
    }
}
