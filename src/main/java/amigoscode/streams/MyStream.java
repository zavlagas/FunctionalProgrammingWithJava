package amigoscode.streams;

import java.util.ArrayList;
import java.util.List;

import static amigoscode.streams.MyStream.Gender.*;

public class MyStream {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("John", MALE));
        people.add(new Person("Maria", FEMAlE));
        people.add(new Person("Aisha", FEMAlE));
        people.add(new Person("Alex", MALE));
        people.add(new Person("Alice", FEMAlE));


//        Stream . Map
//        Map Genders
//        people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);


//        Map Names And name lengths
//        people.stream()
//                .map(person -> person.name)
//                .mapToInt( name -> name.length())
//                .forEach(System.out::println);


//        If the list contains only females
         boolean containsOnlyFemales =  people.stream()
                .allMatch(person -> FEMAlE.equals(person.gender));

        System.out.println(containsOnlyFemales);

//        If the list contains any female

        boolean containsAnyFemale =
                people.stream().anyMatch(person -> FEMAlE.equals(person.gender));

        System.out.println(containsAnyFemale);





    }


    static class Person{

        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
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
