package baseball;

import camp.nextstep.edu.missionutils.Console;


public class GameManager {
    private boolean isContinue;

    public GameManager() {
        this.isContinue = true;
    }

    public void startBaseBallGame() {
        BaseBallGameController baseBallGameController = new BaseBallGameController();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isContinue) {
            baseBallGameController.startGame();

            askContinue();
        }
    }

    private void askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = Console.readLine();

        if (userInput.length() != 1)
            throw new IllegalArgumentException("재시작(1) 또는 종료(2)만 입력해야합니다.");

        if (!userInput.matches("^[1-2]*$"))
            throw new IllegalArgumentException("재시작(1) 또는 종료(2)만 입력해야합니다.");

        if (userInput.equals("2"))
            isContinue = false;
    }
}
