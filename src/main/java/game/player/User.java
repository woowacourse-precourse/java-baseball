package game.player;

import game.number.InputNumbers;

public class User {
    InputNumbers threeNumbers;

    public User() {
        threeNumbers = new InputNumbers();
    }

    public int getNumber(int index) {
        return threeNumbers.getNumber(index);
    }
}
