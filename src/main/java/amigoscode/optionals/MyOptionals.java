package amigoscode.optionals;

import java.util.Optional;

public class MyOptionals
{
    public static void main(String[] args) {

        Optional.ofNullable("Hello from Optional")
                .ifPresent(System.out::println);




    }
}
