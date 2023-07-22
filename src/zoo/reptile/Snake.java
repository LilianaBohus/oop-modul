package zoo.reptile;

public class Snake extends Reptile {

    public Snake(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("SSSSSSSSSHHHHHHH");
    }
}
