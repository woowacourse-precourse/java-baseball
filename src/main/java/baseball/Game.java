package baseball;

public class Game {

    private static Game instance;

    private Computer computer;
    private User user;
    private Round round;

    private Game() {}

    public static Game getGame() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void turnOnGame(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        this.round = Round.getRound(computer, user);
        Print.printGameStart();
    }

    public void startNewGame() {
        this.computer.pickRandomNumbers();
        playGame();
        Print.printGameEnd();
    }

    private void playGame() {
        do {
            round.startNewRound();
        } while (!round.isThreeStrike());
    }

    public boolean replayGame() {
        Print.printReplayGame();
        int inputInt = Input.readInt();
        ReplayNumber replayNumber = new ReplayNumber(inputInt);
        return replayNumber.isReplay();
    }
}
