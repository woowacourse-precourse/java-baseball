package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class EndOrRe {

    private static final String ONE = "1";
    private static final String TWO = "2";

    public Integer makeOneOrTwoInputList() {
        String inputString = Console.readLine();
        validOneOrTwo(inputString);
        return stringToInt(inputString);
    }

    /**
     * 테스트를 위한 메소드
     * 입력받은 문자열을 활용하여 클래스의 메소드들을 테스트하기 위한 메소드
     *
     * @param inputString 입력 받은 문자열이라고 가정한 변수
     * @return 1이나 2의 정수값이 반환된다.
     */
    public Integer printInputString(String inputString) {
        validOneOrTwo(inputString);
        return stringToInt(inputString);
    }

    private Integer stringToInt(String inputString) {
        return Integer.valueOf(inputString);
    }

    private void validOneOrTwo(String inputString) {
        if (!inputString.equals(ONE) && !inputString.equals(TWO)) {
            throw new IllegalArgumentException();
        }
    }
}
