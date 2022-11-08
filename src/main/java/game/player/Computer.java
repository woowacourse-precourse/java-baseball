package game.player;

import game.number.ComputerRandomNumbers;

public class Computer {
    ComputerRandomNumbers threeNumbers;

    public Computer() {
        createThreeNumbers();
    }

    private void createThreeNumbers() {
        threeNumbers = new ComputerRandomNumbers();
    }

    public boolean contains(int number) {
        return threeNumbers.contains(number);
    }

    public int getIndex(int number) {
        return threeNumbers.getIndex(number);
    }
}
