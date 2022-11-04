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
            //TODO: 라운드 결과에 따라 게임을 멈추는 로직 추가
            this.isAnswer = true;
        }
    }
}
