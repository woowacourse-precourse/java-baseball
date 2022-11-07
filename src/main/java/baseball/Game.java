package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    Number number;
    private static List<Integer> computer;
    private static List<Integer> userInput;
    private static boolean end = false;

    public void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        number = new Number();
        setRandomNumber();
        while (!end) {
            proceedGame();
        }
    }

    public void proceedGame() {
        number.userInput();
        userInput = number.userInputNumber;
        checkAnswer();
        resetData();
    }

    public void setRandomNumber() {
        computer = number.createRandomNumber();
    }
    public void checkAnswer() {
        int strike = 0;
        int ball = 0;

        for (Integer input: userInput) {
            boolean isBallNum = isBall(input);
            boolean isStrikeNum = isStrike(input);

            if (isBallNum && isStrikeNum) {
                strike++;
            }
            if (isBallNum && !isStrikeNum) {
                ball++;
            }
        }
        printResult(strike, ball);

        if (strike == 3) {
            if (restart()) {
                computer = number.createRandomNumber();
            }
        }
    }

    public boolean isBall(Integer userInputNumber) {
        if (computer.contains(userInputNumber)) {
            return true;
        }
        return false;
    }

    public boolean isStrike(Integer userInputNumber) {
        if (computer.indexOf(userInputNumber) == userInput.indexOf(userInputNumber)) {
            return true;
        }
        return false;
    }

    public void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (strike == 0) {
            if (ball == 0) {
                System.out.println("낫싱");
            }
            if (ball != 0) {
                System.out.printf("%d볼%n", ball);
            }
        }
        if (strike != 0) {
            if (ball == 0) {
                System.out.printf("%d스트라이크%n", strike);
            }

            if (ball != 0) {
                System.out.printf("%d볼 %d스트라이크%n", ball, strike);
            }
        }
    }

    public boolean restart() {
        String restart = Console.readLine();
        if (restart.equals("2")) {
            end = true;
            computer.clear();
            return false;
        }
        if (restart.equals("1")) {
            userInput.clear();
            computer.clear();
            return true;
        }
        throw new IllegalArgumentException();
    }
    public void resetData() {
        userInput.clear();
    }
}
