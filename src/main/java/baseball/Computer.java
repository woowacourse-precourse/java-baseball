package baseball;

public class Computer {

    private static Computer instance;

    private Numbers computerNumbers;

    private Computer () {}

    public static Computer getComputer() {
        if (instance == null) {
            instance = new Computer();
        }
        return instance;
    }

    public void pickRandomNumbers() {
        this.computerNumbers = Numbers.createRandomNumbers();
    }

    public Number findComputerNumber(int index) {
        return this.computerNumbers.findNumber(index);
    }
}
