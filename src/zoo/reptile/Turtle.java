package zoo.reptile;

public class Turtle extends Reptile {

    public Turtle(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUIRTLEEEE");
    }
}
