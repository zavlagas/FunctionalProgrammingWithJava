package udemy;


import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviorParameter {



    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;
        Predicate<Integer> isOddPredicate = number -> number % 2 == 0;


        filterAndPrint(numbers,isOddPredicate); // isOddWithVariable
        filterAndPrint(numbers, x -> x%2 != 0); //isOddWithInlineDeclaration
        filterAndPrint(numbers,isEvenPredicate);// isEvenWithVariable
        filterAndPrint(numbers, x -> x%2 != 0); //isEvenWithInlineDeclaration

        filterAndPrint(numbers,x -> x%3 == 0);


    }

    private static void filterAndPrint(List<Integer> numbers , Predicate<Integer> predicate){
        numbers.stream()
                .filter( predicate)
                .forEach(System.out::println);
    }



}
