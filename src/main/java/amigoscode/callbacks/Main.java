package amigoscode.callbacks;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        helloWithParameterCallback("jonh",null,value ->{
            System.out.println("No Last Name Provided" + value);
        });
    }


    static void helloWithParameterCallback(String firstName, String lastname , Consumer<String> callback){
        System.out.println(firstName);
        if (lastname != null){
            System.out.println(lastname);
        }else{
            callback.accept(firstName);
        }
    }

    static void hello2WithoutParameterCallback(String firstName, String lastname , Runnable callback){
        System.out.println(firstName);
        if (lastname != null){
            System.out.println(lastname);
        }else{
            callback.run();
        }
    }
}
