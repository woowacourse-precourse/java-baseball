package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ChoiceGame {
    String userChoiceRead = Console.readLine();

    public void userChoiceCheck() {
        if (!(userChoiceRead.charAt(0) == '1' || userChoiceRead.charAt(0) == '2')) {
            throw new IllegalArgumentException("새 게임 시작은 1, 게임 종료는 2를 입력하세요.");
        }
        if (!(userChoiceRead.matches("(.*)[1-2](.*)"))) {
            throw new IllegalArgumentException("새 게임 시작은 1, 게임 종료는 2를 입력하세요.");
        }
    }

    public int chocieGame() {
        int userChoice = Integer.parseInt(userChoiceRead);
        return userChoice;
    }
}
