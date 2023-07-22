package zoo.mammal;

import zoo.Animal;
import zoo.Viviparous;

public abstract class Mammal extends Animal implements Viviparous {
    public Mammal(String name, int age) {
        super(name, age);
    }
}