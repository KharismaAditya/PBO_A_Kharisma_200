public class Main {
    public static void main(String[] args){
        //membuat 2 objek dari kelas Animal
        Anima animal1 = new Anima();
        Anima animal2 = new  Anima();

        //mengisi atribut obek 1
        animal1.name = "Cat";
        animal1.type = "Mammal";
        animal1.sound = "Nyann~~";

        //mengisi atribur objek 2
        animal2.name = "Dog";
        animal2.type = "Mammal";
        animal2.sound = "Woof-Woof!!";

        //memanggil metode hewan untuk setiap objek
        animal1.talk();
        animal2.talk();
    }
}
