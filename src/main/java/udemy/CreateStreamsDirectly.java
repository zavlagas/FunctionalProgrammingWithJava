package udemy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreateStreamsDirectly {

    public static void main(String[] args) {
//        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//
//
//        System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).count());
//
//
//        System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0,Integer::sum));
//
//
//        System.out.println(Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15).reduce(0,Integer::sum));


//        Create Streams with array

        int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};



        System.out.println(Arrays.stream(numberArray).sum());


        System.out.println(Arrays.stream(numberArray).average());


        System.out.println(Arrays.stream(numberArray).min());


        System.out.println(Arrays.stream(numberArray).max());

//        Creating Streams for First 100 Numbers, Squares of Numbers and More

        System.out.println(IntStream.range(1,10).sum()); // <-- exlude the last number

        System.out.println(IntStream.rangeClosed(1,10).sum()); // <-- inclide the last number

        System.out.println(IntStream.iterate(1, e -> e+2).limit(10).sum());

        IntStream.iterate(1, e -> e+2).limit(10).peek(System.out::println).sum();

        IntStream.iterate(2, e -> e+2).limit(10).peek(System.out::println).sum();

        IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum();

//        Convert the primitive IntStream to List

        List<Integer> intStreamToList =
                IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList());


//        - Doing Big Number calculations with BigInteger
        IntStream.rangeClosed(1,50).reduce(1, (x, y) -> x*y); //<-- not correct

        LongStream.rangeClosed(1,50).reduce(1L, (x, y) -> x*y);  //<-- not correct

//        Solution

        IntStream
                .rangeClosed(1,50)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);


    }


}
