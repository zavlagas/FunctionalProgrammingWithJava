package udemy;



import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString(){
        return name + " : " + " : " + noOfStudents + " : " + reviewScore;
    }
}

public class FP04CustomClass {


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


        groupingCoursesIntoMapUsingGroupingBy(courses);


    }

    public static void learning_NoneMatch_AllMatch_AnyMatch(List<Course> courses){

        final Predicate<Course> isAllCoursesBetterThan90 = course -> course.getReviewScore() > 90;
        final Predicate<Course> isAllCoursesBetterThan95 = course -> course.getReviewScore() > 95;
        final Predicate<Course> isAllCoursesLessThan90 = course -> course.getReviewScore() < 90;

        //allMatch

        System.out.println( courses.stream().allMatch(isAllCoursesBetterThan95));


        //noneMatch

        System.out.println( courses.stream().noneMatch(isAllCoursesBetterThan95));

        System.out.println( courses.stream().noneMatch(isAllCoursesLessThan90));

        //anyMatch

        System.out.println( courses.stream().anyMatch(isAllCoursesBetterThan95));


//        Exercise with Students value
        Predicate<Course> isStudentsMoreThan20000 = course -> course.getNoOfStudents() > 20000;
        Predicate<Course> isStudentsMoreThan23000 = course -> course.getNoOfStudents() > 23000;
        Predicate<Course> isStudentsLestThan10000 = course -> course.getNoOfStudents() < 10000;


        System.out.println(courses.stream().noneMatch(isStudentsMoreThan20000));
        System.out.println(courses.stream().allMatch(isStudentsMoreThan20000));
        System.out.println(courses.stream().anyMatch(isStudentsMoreThan20000));


        System.out.println(courses.stream().noneMatch(isStudentsMoreThan23000));
        System.out.println(courses.stream().allMatch(isStudentsMoreThan23000));
        System.out.println(courses.stream().anyMatch(isStudentsMoreThan23000));


        System.out.println(courses.stream().noneMatch(isStudentsLestThan10000));
        System.out.println(courses.stream().allMatch(isStudentsLestThan10000));
        System.out.println(courses.stream().anyMatch(isStudentsLestThan10000));


    }

    public static void sortingCoursesWithSortedAndCreatingComparators(List<Course> courses) {

        Comparator<Course> compararingByNoOfStudentsIncreasing
                = Comparator.comparing(Course::getNoOfStudents);

        System.out.println(courses.stream().
                sorted(compararingByNoOfStudentsIncreasing).
                collect(Collectors.toList()));
//[FullStack :  : 14000 : 91, SpringBoot :  : 18000 : 95, Spring :  : 20000 : 98, Docker :  : 20000 : 92,
// Kubernetes :  : 20000 : 91, AWS :  : 21000 : 92, Azure :  : 21000 : 99, API :  : 22000 : 97, Microservices :  : 25000 : 96]


        Comparator<Course> compararingByNoOfStudentsDecreasing
                = Comparator.comparingInt(Course::getNoOfStudents).reversed();

        System.out.println(courses.stream()
                .sorted(compararingByNoOfStudentsDecreasing)
                .collect(Collectors.toList()));
//[Microservices :  : 25000 : 96, API :  : 22000 : 97, AWS :  : 21000 : 92, Azure :  : 21000 : 99, Spring :  : 20000 : 98,
// Docker :  : 20000 : 92, Kubernetes :  : 20000 : 91, SpringBoot :  : 18000 : 95, FullStack :  : 14000 : 91]


        Comparator<Course> compararingByNoOfStudentsAndNoOfReviews
                = Comparator.comparingInt(Course::getNoOfStudents)
                    .thenComparingInt(Course::getReviewScore)
                        .reversed();

        System.out.println(courses.stream()
                            .sorted(compararingByNoOfStudentsAndNoOfReviews)
                            .collect(Collectors.toList()));
//[Microservices :  : 25000 : 96, API :  : 22000 : 97, Azure :  : 21000 : 99, AWS :  : 21000 : 92, Spring :  : 20000 : 98,
// Docker :  : 20000 : 92, Kubernetes :  : 20000 : 91, SpringBoot :  : 18000 : 95, FullStack :  : 14000 : 91]

    }

    public static void learning_WithSkip_Limit_TakeWhile_DropWhile(List<Course> courses){
        Comparator<Course> compararingByNoOfStudentsAndNoOfReviews
                = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();


        //Limit

        System.out.println(courses.stream()
                .sorted(compararingByNoOfStudentsAndNoOfReviews)
                .limit(5)
                .collect(Collectors.toList()));

//        [Microservices :  : 25000 : 96, API :  : 22000 : 97, Azure :  : 21000 : 99, AWS :  : 21000 : 92, Spring :  : 20000 : 98]


        //Skip

        System.out.println(courses.stream()
                .sorted(compararingByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .collect(Collectors.toList()));

//        [AWS :  : 21000 : 92, Spring :  : 20000 : 98, Docker :  : 20000 : 92, Kubernetes :  : 20000 : 91,
//        SpringBoot :  : 18000 : 95, FullStack :  : 14000 : 91]


        //Cobination of Skip and Limit
        System.out.println(courses.stream()
                .sorted(compararingByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .limit(1)
                .collect(Collectors.toList()));

//        [AWS :  : 21000 : 92]

        System.out.println(courses);

//[Spring :  : 20000 : 98, SpringBoot :  : 18000 : 95, API :  : 22000 : 97, Microservices :  : 25000 : 96,
// FullStack :  : 14000 : 91, AWS :  : 21000 : 92, Azure :  : 21000 : 99, Docker :  : 20000 : 92, Kubernetes :  : 20000 : 91]


        //TakeWhile

//        While course -> course.getReviewScore() >= 95
        System.out.println(courses.stream()
                            .takeWhile(course -> course.getReviewScore() >= 95)
                            .collect(Collectors.toList()));
        //[Spring :  : 20000 : 98, SpringBoot :  : 18000 : 95, API :  : 22000 : 97, Microservices :  : 25000 : 96] >= 95


        //DropWhile
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList()));

        //[FullStack :  : 14000 : 91, AWS :  : 21000 : 92, Azure :  : 21000 : 99, Docker :  : 20000 : 92, Kubernetes :  : 20000 : 91] not >= 95


    }

    public static void finding_Top_Max_Min_CoursesWith_Max_Min_FindFirst_FindAny(List<Course> courses){

        Comparator<Course> compararingByNoOfStudentsAndNoOfReviews
                = Comparator.comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();

//        Max
        System.out.println(courses.stream().max(compararingByNoOfStudentsAndNoOfReviews));  // <--- Returns the last element of the list
        //Optional[FullStack :  : 14000 : 91]
//        Min
        System.out.println(courses.stream().min(compararingByNoOfStudentsAndNoOfReviews)); // <--- Returns the first element of the list
        //Optional[Microservices :  : 25000 : 96]


//        Max and Min With Filter

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() < 90)
                .min(compararingByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Default","default",0,10)));
        //Optional.empty

//        FindFirst
        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 90)
                .findFirst()
                );

//        FindAny

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore() > 90)
                .findAny()
        );
    }

    public static void learningWith_Sum_Average_count(List<Course> courses){

        final Predicate<Course> isAllCoursesBetterThan95 = course -> course.getReviewScore() > 95;

//        Sum
//        To you SUM , you must first map the stream
        System.out.println(
                courses.stream().filter(isAllCoursesBetterThan95)
                .mapToInt(Course::getNoOfStudents)
                .sum()
        );

//        Average
        System.out.println(
                courses.stream().filter(isAllCoursesBetterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

//        Count
        System.out.println(
                courses.stream().filter(isAllCoursesBetterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );


//        Max
        System.out.println(
                courses.stream().filter(isAllCoursesBetterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .max()
        );

//        Min
        System.out.println(
                courses.stream().filter(isAllCoursesBetterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .min()
        );


    }

    public static void groupingCoursesIntoMapUsingGroupingBy(List<Course> courses){

        System.out.println(
                courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory))
        );
//        {Cloud=[AWS :  : 21000 : 92, Azure :  : 21000 : 99, Docker :  : 20000 : 92, Kubernetes :  : 20000 : 91],
//        FullStack=[FullStack :  : 14000 : 91],
//        Microservices=[API :  : 22000 : 97, Microservices :  : 25000 : 96],
//        Framework=[Spring :  : 20000 : 98, SpringBoot :  : 18000 : 95]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
        );
//        {Cloud=4, FullStack=1, Microservices=2, Framework=2}


        System.out.println(
                courses.stream()
                        .collect
                                (Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );

//        {Cloud=Optional[Azure :  : 21000 : 99],
//        FullStack=Optional[FullStack :  : 14000 : 91],
//        Microservices=Optional[API :  : 22000 : 97],
//        Framework=Optional[Spring :  : 20000 : 98]}



        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName,Collectors.toList())))
        );

//        {Cloud=[AWS, Azure, Docker, Kubernetes],
//        FullStack=[FullStack],
//        Microservices=[API, Microservices],
//        Framework=[Spring, SpringBoot]}
    }
}
