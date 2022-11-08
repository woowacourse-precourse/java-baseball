package baseball.domain;

import java.util.*;

public class BallGenerator {

    private BallGenerator() {
    }

    public static List<Ball> getBalls(String s) {
        isValidLength(s);
        return getBallList(s);
    }

    private static void isValidLength(String s) {
        if (isLengthNotThree(s)) throw new IllegalArgumentException();
    }

    private static boolean isLengthNotThree(String s) {
        return s.length() != 3;
    }

    private static List<Ball> getBallList(String s) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = s.charAt(i) - '0';
            isValidRange(number);
            a.add(number);
        }
        return getBallList(a);
    }

    public static List<Ball> getBalls(List<Integer> arr) {
        return getBallList(arr);
    }
    private static List<Ball> getBallList(List<Integer> arr) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int number = arr.get(i);
            isValidRange(number);
            Ball ball = Ball.of(number, i+1);
            result.add(ball);
        }
        return result;
    }

    private static void isValidRange(int number) {
        if (number < 1 || number > 9) throw new IllegalArgumentException();
    }
}
