package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputBallNumber {

    private static final int BALL_NUMBER_LENGTH = 3;

    public String inputBallNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String ballNumbers = Console.readLine();
        validation(ballNumbers);
        return ballNumbers;
    }

    public void validation(String ballNumbers) {
        checkLength(ballNumbers);
        isOnlyNumbers(ballNumbers);
    }

    private void isOnlyNumbers(String ballNumbers) {
        if (!ballNumbers.matches("(^[1-9]*$)")) {
            throw new IllegalArgumentException("1~9까지의 숫자만 입력해주세요.");
        }
    }

    private void checkLength(String ballNumbers) {
        if (ballNumbers.length() != BALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException("1~9까지의 숫자 3개를 입력해주세요.");
        }
    }
}
