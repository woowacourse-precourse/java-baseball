package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private int randomNumber = 0;
    public void startGame() {
        printStartMessage();
        initRandomNumber();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START.getText());
    }

    private void initRandomNumber() {
        randomNumber += Randoms.pickNumberInRange(1, 9) * 100;
        randomNumber += Randoms.pickNumberInRange(1, 9) * 10;
        randomNumber += Randoms.pickNumberInRange(1, 9);
    }
}
