package baseball;

public class Game {

    private Computer computer;
    private Round round;
    private boolean isAnswer;

    public Game() {}

    public void turnOnGame() {
        Print.printGameStart();
    }

    public void startNewGame(Computer computer) {
        this.computer = computer;
        this.isAnswer = false;
        round = new Round(computer);
        while (!isAnswer) {
            round.startNewRound();
            round.playRound();
            this.isAnswer = round.isThreeStrike();
        }
        Print.printGameEnd();
    }

    public boolean replayGame() {
        Print.printReplayGame();
        String inputString = Input.readString();
        ReplayNumber replayNumber = Parse.StringToReplayNumber(inputString);
        return replayNumber.isReplay();
    }
}
