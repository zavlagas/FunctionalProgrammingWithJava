package udemy;


import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FP01Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );
//        printOnlyOddNumbersFromTheList();
//        printAllCoursesIndividually();
//        printAllCoursesContainingSpring();
//        printAllCoursesContainingAtLeast4Letters();
//        printTheNumberOfCharectersInEachCourseName();
//        int total = printTheSquareNumberInAListAndFindTheSumOfSquares();
//        List<Integer> aListWithEvenNumbersFilteredFromTheNumbersList = createAListWithEvenNumbersFilteredFromTheNumbersList(numbers);
//        System.out.println(aListWithEvenNumbersFilteredFromTheNumbersList);

        List<Integer> aListWithLengthsOfAllCourseTitles = createAListWithLengthsOfAllCourseTitles(courses);
        System.out.println(aListWithLengthsOfAllCourseTitles);
    }

//    Exercise 1
    public static void printOnlyOddNumbersFromTheList(){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .filter(number -> number%2 != 0)
                .forEach(System.out::println);

    }
//    Exercise 2
    public static void printAllCoursesIndividually(){
        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "Docker" ,"Kubernetes" );
        courses.forEach(System.out::println);
    }

    //    Exercise 3
    public static void printAllCoursesContainingSpring(){
        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );
        courses.stream()
                .filter(course -> course.toLowerCase().contains("spring"))
                .forEach(System.out::println);
    }

    //    Exercise 4
    public static void printAllCoursesContainingAtLeast4Letters(){
        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    //    Exercise 5
    public static void printTheCubeOfOddNumbers(){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .filter(number -> number%2 == 1)
                .map(number -> number * number)
                .forEach(System.out::println);
    }

    //    Exercise 6
    public static void printTheNumberOfCharectersInEachCourseName(){
        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );
        courses.stream()
                .map( course -> course.length())
                .forEach(System.out::println);
    }

    //Exercise 7]
    public static int printTheSquareNumberInAListAndFindTheSumOfSquares(){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

      return   numbers.stream()
                .map(number -> number * number)
                .reduce(0,Integer::sum);

    }

    //Exercise 8]
    public static int printTheCubeNumberInAListAndFindTheSumOfCubes(){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        return   numbers.stream()
                .map(number -> number * number)
                .reduce(0,Integer::sum);

    }


    //Exercise 9]
    public static int findTheSumOfOddNumbersInAList(){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        return   numbers.stream()
                .filter(number -> number%2 != 0)
                .reduce(0,Integer::sum);

    }

    //Exercise 10
    public static List<Integer> createAListWithEvenNumbersFilteredFromTheNumbersList(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number%2 == 0)
                .collect(Collectors.toList());
    }


    //Exercise 11

    public static List<Integer> createAListWithLengthsOfAllCourseTitles(List<String> courses){
        return courses.stream()
                .map(course -> course.length())
                .collect(Collectors.toList());
    }

    //Exercise 12
    public static void exercise12(){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        BinaryOperator<Integer> sumBinaryOperatorBehindLamda = Integer::sum;

        int sum = numbers.stream().reduce(0, sumBinaryOperator);
    }

}
