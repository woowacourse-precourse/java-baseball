package baseball.dao;

public class ComputerNumber {
    private final int computerNumber;

    public ComputerNumber(int number) {
        this.computerNumber = number;
    }

    public ComputerNumber() {
        this.computerNumber = 123; //TODO - set random pick number
    }

    public int getNumber() {
        return this.computerNumber;
    }
}
