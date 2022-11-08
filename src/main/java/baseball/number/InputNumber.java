package baseball.number;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {

    private static final int BALL_NUMBER_LENGTH = 3;

    public String inputBallNumber() {
        String ballNumbers = Console.readLine();
        validateNumber(ballNumbers);
        return ballNumbers;
    }

    public void validateNumber(String ballNumbers) {
        checkLength(ballNumbers);
        isOnlyNumbers(ballNumbers);
        checkDuplication(ballNumbers);
    }

    private void checkDuplication(String ballNumbers) {
        String firstNumber = getFirstNumber(ballNumbers);
        String secondNumber = getSecondNumber(ballNumbers);
        String thirdNumber = getThirdNumber(ballNumbers);
        if (isDuplication(firstNumber, secondNumber, thirdNumber)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private String getFirstNumber(String ballNumbers) {
        return ballNumbers.substring(0, 1);
    }

    private String getSecondNumber(String ballNumbers) {
        return ballNumbers.substring(1, 2);
    }

    private String getThirdNumber(String ballNumbers) {
        return ballNumbers.substring(2, 3);
    }

    private boolean isDuplication(String firstNumber, String secondNumber, String thirdNumber) {
        return firstNumber.equals(secondNumber) || firstNumber.equals(thirdNumber) || secondNumber.equals(thirdNumber);
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
