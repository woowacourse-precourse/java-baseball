package baseball;

public class Game {

    private static Game instance;

    private Computer computer;
    private Round round;

    private Game() {}

    public static Game getGame() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void turnOnGame() {
        this.computer = Computer.getComputer();
        this.round = Round.getRound();
        Print.printGameStart();
    }

    public void startNewGame() {
        this.computer.pickNewRandomNumbers();
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
