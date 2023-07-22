package zoo.reptile;

import zoo.Animal;
import zoo.Oviparous;

abstract class Reptile extends Animal implements Oviparous {
    public Reptile(String name, int age) {
        super(name, age);
    }
}