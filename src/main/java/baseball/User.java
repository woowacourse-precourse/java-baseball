package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    BaseballGame baseballGame;
    int exit = 1;

    public User() {};

    public void Game() {
        baseballGame = new BaseballGame();

        while (exit == 1) {
            System.out.print("숫자를 입력해주세요 : ");

            int userNumber = input();
            checkThreeDigit(userNumber);

            int end = baseballGame.checkGameResult(userNumber);
            inputExitNumber(end);
        }
    }

    public int input() {
        String inputString = Console.readLine();
        checkInput(inputString);

        return Integer.parseInt(inputString);
    }

    private void inputExitNumber(int end) {
        if (end == 1) {
            exit = input();
            checkExitNumber();

            decideExit();
        }
    }

    private void decideExit() {
        if (exit == 1) {
            baseballGame.resetGame();
        }
    }

    private void checkInput(String inputString) {
        char temp;

        for (int i = 0; i < inputString.length(); i++) {
            temp = inputString.charAt(i);
            checkDigit(temp);
        };
    }

    private void checkDigit(char word) {
        if (!Character.isDigit(word)) {
            throw new IllegalArgumentException("숫자만 입력하시오.");
        }
    }

    private void checkThreeDigit(int gameNumber) {
        List<Integer> gameNumberList = new ArrayList<>();

        while (gameNumber > 0) {
            int n = gameNumber % 10;
            checkDuplication(n, gameNumberList);

            gameNumberList.add(gameNumber % 10);
            gameNumber = gameNumber / 10;
        }

        if (gameNumberList.size() != 3) {
            throw new IllegalArgumentException("세자리로 입력하시오.");
        }
    }

    private void checkDuplication(int number, List<Integer> gameNumberList) {
        if (gameNumberList.contains(number)) {
            throw new IllegalArgumentException("숫자를 중복없이 입력하시오.");
        }
    }

    private void checkExitNumber() {
        if (exit != 1 && exit != 2) {
            throw new IllegalArgumentException("1또는 2만 입력하시오.");
        }
    }
}
