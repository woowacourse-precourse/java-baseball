package baseball;

public class Game {

    private static Game instance;

    private Computer computer;
    private Round round;

    private Game() {}

    public static Game turnOnGame() {
        Print.printGameStart();
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void startNewGame(Computer computer) {
        this.computer = computer;
        this.round = Round.getRound();
        playGame();
        Print.printGameEnd();
    }

    private void playGame() {
        do {
            round.startNewRound(computer);
        } while (!round.isThreeStrike());
    }

    public boolean replayGame() {
        Print.printReplayGame();
        int inputInt = Input.readInt();
        ReplayNumber replayNumber = new ReplayNumber(inputInt);
        return replayNumber.isReplay();
    }
}
