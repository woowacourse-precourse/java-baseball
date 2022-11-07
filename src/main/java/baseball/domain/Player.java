package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private BaseBallNumber playerNumber;

    public void inputNumber() {

        String inputNumber = Console.readLine();
        playerNumber = BaseBallNumber.generatePlayerNumber(inputNumber);

    }

    public BaseBallNumber getPlayerNumber() {
        return playerNumber;
    }
}
