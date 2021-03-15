package udemy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateStreamFunctionality {

    public static void main(String[] args) {
        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );

        joining_StringsWithJoiningAndPlayingWithFlapMap(courses);
    }

    private static void joining_StringsWithJoiningAndPlayingWithFlapMap(List<String> courses){

//   JOINING  / collect(Collector.joining(" ");

        System.out.println(courses.stream().collect(Collectors.joining(",")));


//   SPLIT Strings With FlatMap
//        jshell> "Spring".split("")
//        $1 ==> String[6] { "S", "p", "r", "i", "n", "g" }

        System.out.println
                (
                courses.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList())
        );

//        SPLIT Strings With FlatMap and take the unique chars
        System.out.println
                (
                        courses.stream()
                                .map(course -> course.split(""))
                                .flatMap(Arrays::stream)
                                .distinct()
                                .collect(Collectors.toList())
                );

//        match tuples with the same lenght

        List<String> coursesToMatched =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );

        List<List<String>> resultList = courses.stream()
                .flatMap(course -> coursesToMatched.stream()
                        .filter(course2 -> course2.length() == course.length())
                        .map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList());

        System.out.println(resultList);


    }
}
