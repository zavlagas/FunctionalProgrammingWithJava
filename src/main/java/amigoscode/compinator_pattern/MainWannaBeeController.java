package amigoscode.compinator_pattern;

import java.time.LocalDate;

public class MainWannaBeeController {


    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "6984276685",
                LocalDate.of(2000,1,1)
        );

//        Using Compinator Pattern

        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

        System.out.println(result);

        if( result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }


    }
}
