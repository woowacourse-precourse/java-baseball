package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private boolean gameContinueFlag;
    private NumberManager numberManager = new NumberManager();

    public GameManager() {
        gameContinueFlag = true;
        numberManager.setRandomNumber();
    }

    public void startGame() {

        System.out.println(Message.getGameStartMessage());

        while (gameContinueFlag) {
            System.out.print(Message.getInputNumberMessage());
            StringBuilder userNumber = new StringBuilder(Console.readLine());

            ComparedNumberResult comparedNumberResult = numberManager.getCompareResult(userNumber);

            System.out.println(comparedNumberResult);

            if (comparedNumberResult.getStrikeCount() == 3) {
                gameContinueFlag = checkGameContinueFlag(); // 게임을 재시작 할 경우, 무작위 수 재설정
            }
        }

    }
}
