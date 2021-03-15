package amigoscode.functional_interface;

import java.util.function.Supplier;

public class MySupplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }


//    Classic Method
    static String getDBConnectionUrl (){
        return "jdbc://localhost:8432/users";
    }

//    Supplier Method
    static Supplier<String> getDBConnectionUrlSupplier = ()
        -> "jdbc://localhost:8432/users";
 }
