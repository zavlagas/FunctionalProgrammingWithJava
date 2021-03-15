package udemy;

import java.util.stream.LongStream;

public class ParallelizingStreams {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();

        // 0 , 10000000

//        System.out.println(LongStream.range(0,10000000)
//                .sum()); //49999995000000  42

        System.out.println(LongStream.range(0,10000000)
                .parallel()  // 20% percent faster
                .sum());

        System.out.println(System.currentTimeMillis() - time);
    }
}
