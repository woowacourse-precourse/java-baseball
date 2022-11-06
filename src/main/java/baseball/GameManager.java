package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private static final int CONTINUE = 1;
    private static final int EXIT = 2;
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

            numberManager.validate(userNumber);

            ComparedNumberResult comparedNumberResult = numberManager.getComparedResult(userNumber);

            System.out.println(comparedNumberResult);

            if (comparedNumberResult.getStrikeCount() == userNumber.length()) {
                gameContinueFlag = checkGameContinueFlag(); // 게임을 재시작 할 경우, 무작위 수 재설정
            }
        }

    }

    public boolean checkGameContinueFlag() {

        System.out.println(Message.getGameEndMessage());
        System.out.println(Message.getGameContinueCheckMessage());

        int gameContinue = Integer.parseInt(Console.readLine());

        switch (gameContinue) {
            case CONTINUE:
                numberManager.setRandomNumber();
                return true;
            case EXIT:
                return false;
            default:
                throw new IllegalArgumentException();
        }

    }
}
