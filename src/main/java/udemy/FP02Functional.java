package udemy;


import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {

        final List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<Integer> doubleNumbers = doubleList(numbers);

        System.out.println(doubleNumbers);



    }

    private static List<Integer> doubleList(List<Integer> numbers) {

        return numbers.stream()
                .map(number -> number*number)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate , int nextNumber){
        System.out.println( aggregate + " /" + nextNumber);
        return (aggregate + nextNumber);
    }

    private static int addListFunctional(List<Integer> numbers) {

       return numbers.stream()
                //combine them into one result => value
                // 0 and (a,b) -> a+b
                // 0 and FP02Functional::sum
//        .reduce(0,FP02Functional::sum);
//            OR
//        .reduce(0,(aggregate,nextNumber) -> aggregate+nextNumber);  <-- Lamda Express
//            OR
          .reduce(0,Integer::sum); // Method Reference of Integer Object Sum
    }


}
