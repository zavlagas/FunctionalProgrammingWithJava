package amigoscode.functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyFunction {

    public static void main(String[] args) {

        //Function takes 1 argument and produces one result

        //Add One with Function Interface

       Integer increment2 =  incrementByOneFunction.apply(5);
       System.out.println(increment2);


        //Mutli with Function Interface
        Integer multi = multiplyBy10Function.apply(increment2);
        System.out.println(multi);


        //Compine Functions

       Integer compinedMethodResult = incrementByOneFunction.andThen(multiplyBy10Function).apply(2);
       System.out.println(compinedMethodResult);


       ///BiFunction takes 2 argument and produces one result

      int biFunctionResult =  incrementByOneAndMultiplyByFunction.apply(5,4);
      System.out.println(biFunctionResult);
    }


    // Functional Methods

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;


    //BiFunction Methods
   static BiFunction<Integer,Integer , Integer> incrementByOneAndMultiplyByFunction =
            (numberToIncrementByOne,numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

}
