package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumber;

    public Player() {
        this.playerNumber = new ArrayList<>();
    }

    public List<Integer> getPlayerNumber() {
        return this.playerNumber;
    }

    public void setPlayerNumber(String inputNumber) {
        checkInputStyle(inputNumber);
        setNumber(inputNumber);
    }

    public void checkInputStyle(String inputNumber) {
        String REGEX = "^[1-9]*";

        if (inputNumber.length() != 3 || !inputNumber.matches(REGEX)) {
            inputError();
        }
    }

    public void setNumber(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            int unit = inputNumber.charAt(i) - '0';
            checkOverlab(unit);
            playerNumber.add(unit);
        }
    }

    public void checkOverlab(int unit) {
        if (playerNumber.contains(unit)) {
            inputError();
        }
    }

    public void inputError() {
        throw new IllegalArgumentException();
    }
}


