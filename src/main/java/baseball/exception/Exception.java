package baseball.exception;


import baseball.constant.Constant;

public class Exception {

    public static void isOneOrTwo(int number) throws IllegalArgumentException {

        if (!(number == 1 || number == 2)) {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요");
        }
    }

    public static void isInputTypeNumber(String Number) throws IllegalArgumentException {

        for (int i = 0; i < Number.length(); i++) {
            if (!Character.isDigit(Number.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력해주세요");
            }
        }
    }

    public static void isInputLengthThree(String Number) throws IllegalArgumentException {

        if (Number.length() != Constant.NUMBER_SIZE) {
            throw new IllegalArgumentException("입력 숫자 길이가 3이 아닙니다");
        }
    }
}
