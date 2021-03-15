package udemy;


import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterExercises {



    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;
        Predicate<Integer> isOddPredicate = number -> number % 2 == 0;
        Function<Integer,Integer> squereFuntion = number -> number*number;

//        filterAndPrint(numbers,isOddPredicate); // isOddWithVariable
//        filterAndPrint(numbers, x -> x%2 != 0); //isOddWithInlineDeclaration
//        filterAndPrint(numbers,isEvenPredicate);// isEvenWithVariable
//        filterAndPrint(numbers, x -> x%2 != 0); //isEvenWithInlineDeclaration
//        filterAndPrint(numbers,x -> x%3 == 0);

        mapAndCollect(numbers,x->x*x);
        mapAndCollect(numbers,x->x*x*x);
    }

    private static void filterAndPrint(List<Integer> numbers , Predicate<Integer> predicate){
        numbers.stream()
                .filter( predicate)
                .forEach(System.out::println);
    }

    private static List<Integer> mapAndCollect(List<Integer> numbers , Function<Integer,Integer> function){
        List<Integer> newList = numbers.stream()
                .map(function)
                .collect(Collectors.toList());

        System.out.println(newList);
        return newList;
    }

}
