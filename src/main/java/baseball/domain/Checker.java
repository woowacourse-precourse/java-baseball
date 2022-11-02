package baseball.domain;

public class Checker {
    public static boolean hasDifferentNumbers(String numbers) {
        return numbers.chars().distinct().count() == numbers.length();
    }
}
