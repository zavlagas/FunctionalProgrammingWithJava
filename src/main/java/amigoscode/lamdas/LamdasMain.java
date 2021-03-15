package amigoscode.lamdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LamdasMain {

    public static void main(String[] args) {

//One Parameter with Quick Return , no extra logic
        Function<String,String> upperCaseName1 =
                name -> name.toUpperCase();

//One Parameter with Return and extra logic
        Function<String,String> upperCaseName2 =
                name ->{
                    //extra logic
                    if(name.isEmpty()) throw new IllegalArgumentException("Name Is Empty");
                    return name.toUpperCase();
                };
        //Two Parameters with Return and extra logic
        BiFunction<String,Integer,String> upperCaseName4 =
                (name,age) ->{
                    //extra logic
                    if(name.isEmpty()) throw new IllegalArgumentException("Name Is Empty");
                    System.out.println(age);
                    return name.toUpperCase();
                };
    }




}



