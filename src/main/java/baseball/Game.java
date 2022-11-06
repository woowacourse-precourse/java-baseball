package baseball;

public class Game {

    // 싱글톤 패턴
    private static Game instance;

    private Game() {}

    public static Game turnOnGame() {
        Print.printGameStart();
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    private Computer computer;
    private Round round;
    private boolean isWin;

    public void startNewGame(Computer computer) {
        this.computer = computer;
        this.isWin = false;
        round = new Round(computer);
        while (!isWin) {
            round.startNewRound();
            this.isWin = round.isThreeStrike();
        }
        Print.printGameEnd();
    }

    public boolean replayGame() {
        Print.printReplayGame();
        int inputInt = Input.readInt();
        ReplayNumber replayNumber = new ReplayNumber(inputInt);
        return replayNumber.isReplay();
    }
}
