package udemy;

import java.util.List;
import java.util.function.Predicate;

public class HigherOrderFunction {

    public static void main(String[] args) {
        List<Course> courses =
                List.of(
                        new Course("Spring", "Framework", 98, 20000),
                        new Course("SpringBoot", "Framework", 95, 18000),
                        new Course("API", "Microservices", 97, 22000),
                        new Course("Microservices", "Microservices", 96, 25000),
                        new Course("FullStack", "FullStack", 91, 14000),
                        new Course("AWS", "Cloud", 92, 21000),
                        new Course("Azure", "Cloud", 99, 21000),
                        new Course("Docker", "Cloud", 92, 20000),
                        new Course("Kubernetes", "Cloud", 91, 20000)
                );

        int cutOffReviewScore = 95;

        final Predicate<Course> isAllCoursesBetterThan90 = createPredicateWithCutOffReviewScore(90);
        final Predicate<Course> isAllCoursesBetterThan95 = createPredicateWithCutOffReviewScore(95);
    }

//    This is a Higher Order Function
    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore){
        return course -> course.getReviewScore() > cutOffReviewScore;
    }

}
