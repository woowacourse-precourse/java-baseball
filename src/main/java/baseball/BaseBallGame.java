package baseball;

public class BaseBallGame {

    private final Computer computer;

    public BaseBallGame(Computer computer) {
        this.computer = computer;
    }

    private void init() {
        computer.generateUniqueRandomNumbers();
    }
}
