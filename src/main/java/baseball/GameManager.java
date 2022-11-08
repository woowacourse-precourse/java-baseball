package baseball;

public class GameManager {
    private final Computer computer;
    private final Referee referee;
    private boolean continueGame;
    private static final int NUMBER_LENGTH = 3;
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public GameManager() {
        this.computer = new Computer();
        this.referee = new Referee();
        this.continueGame = true;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        while (this.continueGame) {
            referee.setBallandStrike(computer.getTargetNumber(), InputView.getUserInput());
            System.out.println(referee.resultMessage());
            if (referee.getStrike() == NUMBER_LENGTH) {
                System.out.println(END_GAME);
                this.continueGame = false;
                break;
            }
        }
        if (InputView.restartGame().equals("1")) {
            this.continueGame = true;
            play();
        }
    }
}
