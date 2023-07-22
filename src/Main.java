import bank.BankAccount;
import person.Person;
import shape.Circle;
import shape.Rectangle;
import shape.Shape;
import shape.Square;
import zoo.Zoo;
import zoo.bird.Eagle;
import zoo.mammal.Cat;
import zoo.mammal.Dog;
import zoo.mammal.Mammal;
import zoo.reptile.Snake;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Person
        Person gipsz_jakab = new Person("Gipsz Jakab", 28, Person.Gender.MALE);
        Person akcios_aron = new Person("Akciós Áron", 24, Person.Gender.MALE);

        gipsz_jakab.becomeFriends(akcios_aron);

        assert Person.getPopulation() == 2;
        assert gipsz_jakab.getGender().getEn() == "male";
        assert gipsz_jakab.getGender().getHu() == "férfi";

        assert gipsz_jakab.getFriends().contains(akcios_aron);
        assert akcios_aron.getFriends().contains(gipsz_jakab);

        System.out.println(akcios_aron.toString());

        // Bank
        assert BankAccount.isValidAccountNumber(new BankAccount("Gipsz Jakab", "929")) == true;
        assert BankAccount.isValidAccountNumber(new BankAccount("Akciós Áron", "1")) == false;

        // ZOO
        Zoo zoo = new Zoo();
        zoo.addAnimal(new Dog("Bundás", 2));
        zoo.addAnimal(new Snake("DangerNoodle", 3));
        zoo.addAnimal(new Eagle("Totó", 3));
        zoo.addAnimal(new Cat("Malac", 3));

        zoo.boogie();
        System.out.println("*****");
        zoo.listAnimals();
        System.out.println("*****");
        zoo.listAnimals(Mammal.class);

        // SHAPE
        var shapes = new ArrayList<Shape>();
        shapes.add(new Circle(4));
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Square(4));

        shapes.forEach(shape -> {
            System.out.println(shape.getClass().getName());
            System.out.println(shape.getArea());
            System.out.println(shape.getPerimeter());
            System.out.println("*****");
        });
    }
}