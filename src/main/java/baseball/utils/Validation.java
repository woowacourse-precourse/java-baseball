package baseball.utils;

public class Validation {

    public static void IsOnlyNumber(String input) {
        char[] chars = input.toCharArray();
        for (char alphabet : chars) {
            if (Character.isDigit(alphabet) == false)
                throw new IllegalArgumentException("숫자 외의 문자를 입력하셨습니다.");
        }
    }

    public static void IsNumberThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3글자의 숫자입니다.");
        }
    }

}
