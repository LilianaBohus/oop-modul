package zoo.bird;

import zoo.Animal;
import zoo.Flyable;
import zoo.Oviparous;

public abstract class Bird extends Animal implements Oviparous, Flyable {
    public Bird(String name, int age) {
        super(name, age);
    }
}
