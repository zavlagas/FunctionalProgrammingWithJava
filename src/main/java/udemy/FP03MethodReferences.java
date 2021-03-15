package udemy;


import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03MethodReferences {


    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );


    courses.stream()
//            .map(str -> str.toUpperCase()) <--- lamda exp
            .map(String::toUpperCase) // <---method reference
//            .forEach(str -> System.out.println(str))
            .forEach(System.out::println);


//    Supplier<String> supplier = () -> new String();
//      OR
    Supplier<String> supplier = String::new;
    }







}
