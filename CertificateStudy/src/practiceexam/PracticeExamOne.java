package practiceexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class PracticeExamOne {

    private static void hippo(short num1, short num2) {
        System.out.println("shorts");
    }
    private static void hippo(int... nums) {
        System.out.println("varargs");
    }
    private static void hippo(Integer num1, Integer num2) {
        System.out.println("Integers");
    }
    private static void hippo(long num1, long num2) {
        System.out.println("longs");
    }

    public static void main(String[] args) {
//        hippo(1,2);
//        var tour = new String[] {
//                "Downtown", "Uptown", "Brooklyn" };
//        var times = new String[] { "Day", "Night" };
//        for (int i = 0, j = 0; i < tour.length; i++, j++)
//            System.out.println(tour[i] + " " + times[j]);

//        record Earthworm(int length) {
//            Earthworm {
//                length = 4;
//            }
//        }
//        var worm = new Earthworm(6);
//        System.out.println(worm.length());
        System.out.println(20.0 + Math.abs(20));
    }

    //answer is E: compiler error on line c3
//    public static void questionOne() {
//        var result =
//                Stream.of(getNums(9, 8), getNums(22, 33)) // c1
//                        .flatMap(x -> x) // c2
//                        .map((a, b) -> a - b) // c3 // error map doesnt take bifunction, but function
//                        .filter(x -> !x.isEmpty()) // c4
//                        .get();
//        System.out.println(result);
//    }
//    private static Stream<Integer> getNums(int num1, int num2) {
//        return Stream.of(num1, num2);
//    } }

    //question1: E // correct
    //question2: B, F // correct
    //question3: B, C, E // correct
    //question4: study
    //question5: A // correct
    //question6: A, C, F // correct
    //question7: A, D // correct
    //question8: E // correct
    //question9: B, wheel2 and wheel 5 // correct
    //question10: B, F // correct
    //question11: C // correct
    //question12: study
    //question13: D // correct
    //question14: F // correct
    //question15: B // correct // Service locator - requires; Service provider - exports or something
    //question16: E // correct
    //question17: study
    //question18: study
    //question19: A, D, E // correct
    //question20: A, B, D // correct
    //question21: C // correct
    //question22: A // correct
    //question23: C // false -> correct is B
    //question24: A, C, E // correct
    //question25: B, E // correct
    //question26: study
    //question27: A, D // false -> correct is B, D
    //question28: E // correct
    //question29: C // correct
    //question30: study
    //question31: D // correct
    //question32: E // correct
    //question33: C // false -> correct is E
    //question34: F // correct  -> doesnt compile because grow overrides parent method in a wrong way: super.Plant.grow() instead of Plant.super.grow()
    //question35: B // correct
    //question36: study
    //question37: D // correct  -> doesnt compile because switch expression required case keyword for each case
    //question38: B, D, F // correct
    //question39: study (too long cba reading)
    //question40: D // correct
    //question41: B, E // correct
    //question42: study
    //question43: study (exceptions->cba)
    //question44: D // correct
    //question45: D // correct
    //question46: study
    //question47: B // correct
    //question48: B // correct // variable s is not effectively final (try-with-resources requries final or effectively final variables), in catch block child and parent exceptions cant be declared
    //question49: A // correct
    //question50: study
    //question:
    //question:
    //question:
    //question:
    //question:
    //question:
    //question:
    //question:
    //question:
}
