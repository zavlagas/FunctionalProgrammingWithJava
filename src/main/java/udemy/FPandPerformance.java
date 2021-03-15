package udemy;

import java.util.List;

public class FPandPerformance {

    public static void main(String[] args) {

        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );



        System.out.println( courses.stream()
                .peek(System.out::println)
                .filter(course -> course.length() > 11)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst());

    }
}
