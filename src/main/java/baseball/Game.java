package baseball;

public class Game {

    private Computer computer;
    private User user;
    private Round round;

    public Game() {}

    public void turnOnGame(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        this.round = new Round();
        Print.printGameStart();
    }

    public void startNewGame() {
        this.computer.pickRandomNumbers();
        playGame();
        Print.printGameEnd();
    }

    private void playGame() {
        do {
            round.startNewRound(user, computer);
        } while (!round.isThreeStrike());
    }

    public boolean replayGame() {
        Print.printReplayGame();
        int inputInt = Input.readInt();
        ReplayNumber replayNumber = new ReplayNumber(inputInt);
        return replayNumber.isReplay();
    }
}
