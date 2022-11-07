package baseball.utils;

public class Validation {

    //숫자를 제대로 입력했는지 확인 하는 메서드 생성
    public static void IsOnlyNumber(String input) {
        char[] chars = input.toCharArray();
        for (char alphabet : chars) {
            if (Character.isDigit(alphabet) == false)
                throw new IllegalArgumentException("숫자 외의 문자를 입력하셨습니다.");
        }
    }
}
