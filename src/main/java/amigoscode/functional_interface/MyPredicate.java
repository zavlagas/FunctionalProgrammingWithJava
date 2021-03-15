package amigoscode.functional_interface;

import java.util.function.Predicate;

public class MyPredicate {

    public static void main(String[] args) {

//        Classic Way
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07000000000"));

        System.out.println(isPhoneNumberValid("09000000000"));


//        Predicate Way
        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidWithPredicate.test("07000003000"));
        System.out.println(isPhoneNumberValidWithPredicate.test("08000000000"));

//        Compine  Predicates (And)
        System.out.println("With Compined Predicates (And)");
        System.out.println(isPhoneNumberValidWithPredicate.and(containsNumber3).test("07000000000"));

        //        Compine Predicates (Or)
        System.out.println("With Compined Predicates (Or)");
        System.out.println(isPhoneNumberValidWithPredicate.or(containsNumber3).test("07000000000"));
    }


//    Classic Java way Method
    static boolean isPhoneNumberValid ( String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

//    Predicate Java Way Method
    static Predicate<String> isPhoneNumberValidWithPredicate =
        phoneNumber ->phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");
}
