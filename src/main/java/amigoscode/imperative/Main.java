package amigoscode.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static amigoscode.imperative.Main.Gender.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", MALE));
        people.add(new Person("Maria", FEMAlE));
        people.add(new Person("Aisha", FEMAlE));
        people.add(new Person("Alex", MALE));
        people.add(new Person("Alice", FEMAlE));

        //Imperative approach
        System.out.println("<<<IMPERATIVE APPROACH>>>");
        List<Person> females = new ArrayList<>();

        for (Person person : people){
            if(FEMAlE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person person : females){
            System.out.println(person);
        }


        System.out.println("<<<DECLARATIVE APPROACH>>>");
        ///Declarative
        Predicate<Person> personPredicate = person -> FEMAlE.equals(person.gender);
        List<Person> streamFemales =   people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

     streamFemales.forEach(System.out::println);


    }

    static class Person{

        private final String name;
        private final Gender gender;

        Person(String name,Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE,FEMAlE
    }
}
