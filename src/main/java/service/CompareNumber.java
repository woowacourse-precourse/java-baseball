package service;

import domain.Number;

import java.util.List;

public class CompareNumber {
    private static final int CORRECT_ANSWER = 3;
    private static final int NO_COUNT = 0;

    private List<Number> userNumber;
    private List<Number> computerNumber;

    public CompareNumber(List<Number> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public boolean compare() {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < CORRECT_ANSWER; i++) {
            if (this.userNumber.get(i).equals(this.computerNumber.get(i))) {
                strikeCount++;
            } else if (userNumber.contains(computerNumber.get(i))) {
                ballCount++;
            }
        }
        return printHint(strikeCount, ballCount);
    }

    private boolean printHint(int strikeCount, int ballCount) {
        if (ballCount > NO_COUNT) {
            System.out.println(ballCount + "볼" + " ");
        }
        if (strikeCount > NO_COUNT) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (ballCount + strikeCount == NO_COUNT) {
            System.out.println("낫싱");
        }
        if (strikeCount == CORRECT_ANSWER) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public void setUserNumber(List<Number> userNumber) {
        this.userNumber = userNumber;
    }

    public void setComputerNumber(List<Number> computerNumber) {
        this.computerNumber = computerNumber;
    }
}
