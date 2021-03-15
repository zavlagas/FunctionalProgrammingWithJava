package amigoscode.functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MyConsumer {

    public static void main(String[] args) {
        //    Classic Java Way function
      greetCustomer(new Customer( "Maria" , "6984276685"));

      // Consumer Functional interface Way take one argument
        greetCustomerWithConsumer.accept(new Customer( "Maria" , "6984276685"));

        // BiConsumer Functional interface Way takes 2 arguments

        greetCustomerConsumerWithBiConsumer.accept(new Customer( "Maria" , "6984276685"),false);
    }

//    Consumer Way
    static Consumer<Customer> greetCustomerWithConsumer =
        customer ->  System.out.println("Hello " + customer.customerName +
                ", thanks from registering phone number "
                + customer.customerPhoneNumber);

//    BiConsumer way
static BiConsumer<Customer,Boolean> greetCustomerConsumerWithBiConsumer =
        (customer , showPhoneNumber) ->  System.out.println("Hello " + customer.customerName +
                ", thanks from registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "************"));

//    Classic Way
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName +
                ", thanks from registering phone number "
                + customer.customerPhoneNumber);
    }

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
