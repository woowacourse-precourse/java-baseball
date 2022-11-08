package baseball.service;

import java.util.List;

public class Player {
    private ThreeNumber number;

    public Player() {
        this.number = new ThreeNumber();
    }

    public List<Integer> getThreeNumber() {
        return number.getNumber();
    }

    public int getNumber(int index) {
        return number.getNumber().get(index);
    }

    public void setNumber(String input) {
        number = new ThreeNumber();
        number.setNumber(input);
    }
}
