package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    BaseballGame baseballGame;

    public User() {};

    public void Game() {
        baseballGame = new BaseballGame();

        System.out.print("숫자를 입력해주세요 : ");
        int userNumber = input();
        checkThreeDigit(userNumber);
    }

    public int input() {
        String inputString =readLine();
        checkInput(inputString);

        return Integer.parseInt(inputString);
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
}
