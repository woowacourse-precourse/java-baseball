package baseball;

public class BaseballGame {

    private static final Integer RESTART = 1;
    private static final Integer EXIT = 2;

    private Player player;

    private Computer computer;

    private Hint hint;

    private boolean progress;

    public BaseballGame() {
        this.player = new Player();
        this.computer = new Computer();
        this.hint = new Hint();
        this.progress = true;
    }

    private static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        printStartMessage();
        while (progress) {
            startGame();
            checkProgress();
        }
    }

    public void startGame() {
        computer.pickRandomNumbers();
        do {
            player.getBaseballInput();
            System.out.println(hint.getBaseballResult(this.player, this.computer));
        } while (!hint.isThreeStrike());
    }

    private void checkProgress() {
        Integer progressInput = player.getProgressInput();
        if (progressInput == RESTART) {
            this.progress = true;
        } else if (progressInput == EXIT) {
            this.progress = false;
        }
    }
}
