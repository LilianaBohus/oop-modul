package zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private final List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void listAnimals() {
        animals.forEach(System.out::println);
    }

    public <T extends Animal> void listAnimals(Class<T> tClass) {
        animals
                .stream().filter(animal -> tClass.isAssignableFrom(animal.getClass()))
                .forEach(System.out::println);
    }

    public void boogie() {
        animals.forEach(Animal::makeSound);
    }
}
