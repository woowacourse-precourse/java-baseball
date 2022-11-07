package baseball.model;

import static baseball.exception.Exception.*;

public class PlayerNumber {

    private String playerNumber;

    public void setPlayerNumber(String playerNumber) {

        isInputLengthThree(playerNumber);
        isInputTypeNumber(playerNumber);
        isExistZeroInNumber(playerNumber);
        isExistSameNumber(playerNumber);
        this.playerNumber = playerNumber;
    }
}

