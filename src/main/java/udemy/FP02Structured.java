package udemy;


import java.util.List;

public class FP02Structured {

    public static void main(String[] args) {

        final List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = addListStructured(numbers);
        System.out.println(sum);

    }

    private static int addListStructured(List<Integer> numbers) {
//        how to loop ?
//        How to store the sum?
        int sum = 0;
        for (Integer number:numbers){
            sum += number;
        }
        return sum;
    }


}
