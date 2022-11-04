package baseball;

public class GameNumbers {
    private final int computer;
    private final int player;

    public GameNumbers(int computer, int player) {
        this.computer = computer;
        this.player = player;
    }

    public Scoreboard compare() {
        return new Scoreboard();
    }
}
