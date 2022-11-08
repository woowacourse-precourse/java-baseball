package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    Number number;
    private static List<Integer> computer;
    private static List<Integer> userInput;
    private boolean end = false;
    private int strike = 0;
    private  int ball = 0;

    public void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        number = new Number();
        setRandomNumber();
        while (!end) {
            proceedGame();
            if (strike == 3) {
                restart();
            }
            resetData();
        }
    }

    public void proceedGame() {
        number.userInput();
        userInput = number.userInputNumber;
        checkAnswer();
        printResult();
        userInput.clear();
    }

    public void setRandomNumber() {
        computer = number.createRandomNumber();
    }
    public void checkAnswer() {
        for (Integer input: userInput) {
            if (isBall(input) && isStrike(input)) {
                strike++;
            }
            if (isBall(input) && !isStrike(input)) {
                ball++;
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
        int computerNumberLocation = computer.indexOf(userInputNumber);
        int userNumberLocation = userInput.indexOf(userInputNumber);
        if (computerNumberLocation == userNumberLocation) {
            return true;
        }
        return false;
    }

    public void printResult() {
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

    public void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            userInput.clear();
            computer.clear();
            setRandomNumber();
        }
        if (input.equals("2")) {
            end = true;
            computer.clear();
        }
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
    public void resetData() {
        strike = 0;
        ball = 0;
    }
}
