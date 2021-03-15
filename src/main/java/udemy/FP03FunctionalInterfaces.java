package udemy;


import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces {


    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);


//        PREDICATE

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Predicate<Integer> isEvenPredicateBehindLambda = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return (number%2 ==0);
            }
        };


//      FUNCTION

        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, Integer> squareFunctionBehindLambda = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return (number*number);
            }
        };



//     CONSUMER

        Consumer<Integer> soutConsumer = System.out::println;

        Consumer<Integer> soutConsumerBehindLamda = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };

//      BINARY OPERATOR

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        BinaryOperator<Integer> sumBinaryOperatorBehindLamda = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer sum, Integer extra) {
                return (sum + extra);
            }
        };

        int sum = numbers.stream().reduce(0, sumBinaryOperator);

//      SUPPLIER


        //No Input -> Return Something
        Supplier<Integer> randomIntegerSupplier = () -> {
            return new Random().nextInt(1000);
        };

//        System.out.println(randomIntegerSupplier.get());


//      UNARYOPERATOR (Takes only one argument

        UnaryOperator<Integer> unaryOperator = x -> 3 * x;

//        System.out.println(unaryOperator.apply(4));


//        BIPREDICATE
//        Takes 2 arguments and returns an boolean
        BiPredicate<Integer , Integer> isEqual = (first,second) -> first == second;

        System.out.println(isEqual.test(1,2));

        BiPredicate<Integer , Integer> checkValues = (first,second) -> {
            return first > 10 && second < 10;
        };


//        BIFUNCTION
//        Takes 2 arguments and returns one output except boolean

        BiFunction<Integer,Integer,Integer> sumTheArguments = (first, second) -> first + second;

        System.out.println(sumTheArguments.apply(1,1));


//        BICONSUMER
//        Takes 2 arguments and voids
        BiConsumer <Integer,String> printTheArguments = (first,second) -> System.out.println("The first is : " + first + " And Second Is " + second);

        printTheArguments.accept(20,"Nick");




        //    INT BINARY OPERATOR

        IntBinaryOperator intBinaryOperator = (x,y) -> x+y;
        intBinaryOperator.applyAsInt(1,2);

    }







}
