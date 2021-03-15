package udemy;


import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        final List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        printAllNumbersInListFunctionalWithMethodRefenance(numbers);
//        printEvenNumbersInListFunctionalWithMethodRefenance(numbers);
        printSqueresOfEvenNumbersInListFunctionalWithMethodRefenance(numbers);

    }

    private static void print(int number){
        System.out.println(number);
    }

    private static boolean isEven(int number){
        return number%2 == 0;
    }

    private static void printAllNumbersInListFunctionalWithMethodRefenance(List<Integer> numbers) {

//        How to loop the numbers?
//         With Streams And Method Reference -> (nameOftheClass:: Function) --> .forEach(FP01Functional::print);
        numbers.stream()
                .forEach(FP01Functional::print); // <---Method Reference

        //OR
        numbers.stream()
                .forEach(System.out::println); // <---Method Reference (
    }

    private static void printEvenNumbersInListFunctionalWithMethodRefenance(List<Integer> numbers) {

        numbers.stream()
                .filter(FP01Functional::isEven) // Filter allow even Numbers
                .forEach(System.out::println); //method reference

        //OR
        numbers.stream()
                .filter(number -> number % 2 ==0 ) //filter with lamda expression
                .forEach(System.out::println);
    }


    private static void printSqueresOfEvenNumbersInListFunctionalWithMethodRefenance(List<Integer> numbers) {

        numbers.stream()
                .filter(number -> number % 2 ==0 ) //filter with lamda expression
                .map(number -> number * number)
                .forEach(System.out::println);
    }
}
