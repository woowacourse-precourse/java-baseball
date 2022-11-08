package baseball;

public class Game {
    private Computer computer;
    private Hint hint;
    private Output output;

    public Game() {
        this.computer = new Computer();
        this.hint = new Hint();
        this.output = new Output();
    }

    public Computer getComputer() {
        return computer;
    }

    public Hint getHint() {
        return hint;
    }

    public Output getOutput() {
        return output;
    }

}
