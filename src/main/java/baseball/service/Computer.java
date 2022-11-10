package baseball.service;

public class Computer {
    private final ThreeNumber number;

    public Computer() {
        number = new ThreeNumber();
    }

    public ThreeNumber getThreeNumber() {
        return number;
    }

    public void generateRandomNumber() {
        number.generate();
    }
}
