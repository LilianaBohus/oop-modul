package person;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private static long population = 0;

    private String name;
    private int age;
    private Gender gender;
    private List<String> hobbies = new ArrayList<>();
    private List<Person> friends = new ArrayList<>();

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        Person.population++;
    }

    public void becomeFriends(Person friendlyPerson) {
        if (!friends.contains(friendlyPerson)) {
            friends.add(friendlyPerson);
            friendlyPerson.becomeFriends(this);
        }
    }

    public enum Gender {
        MALE("férfi", "male"),
        FEMALE("nő", "female");

        private final String hu;
        private final String en;

        Gender(String hu, String en) {
            this.hu = hu;
            this.en = en;
        }


        public String getHu() {
            return hu;
        }

        public String getEn() {
            return en;
        }
    }

    public static long getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public List<Person> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hobbies=" + hobbies +
                ", friends=" + friends.stream().map(Person::getName).toList() +
                '}';
    }
}
