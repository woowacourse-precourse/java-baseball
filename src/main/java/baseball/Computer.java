package baseball;

public class Computer {

    private Numbers computerNumbers;

    public Computer () {}

    public void pickRandomNumbers() {
        this.computerNumbers = Numbers.createRandomNumbers();
    }

    public Number findComputerNumber(int index) {
        return this.computerNumbers.findNumber(index);
    }
}
