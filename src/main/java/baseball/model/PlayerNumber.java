package baseball.model;

import baseball.exception.Exception;

public class PlayerNumber {

    private String playerNumber;

    public void setPlayerNumber(String playerNumber) {

        Exception.isInputLengthThree(playerNumber);
        Exception.isInputTypeNumber(playerNumber);
        Exception.isExistZeroInNumber(playerNumber);
        Exception.isExistSameNumber(playerNumber);
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {

        return playerNumber;
    }
}

