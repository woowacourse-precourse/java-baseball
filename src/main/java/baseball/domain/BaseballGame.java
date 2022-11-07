package baseball.domain;

public class BaseballGame {

    private static final Integer RESTART = 1;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private final Player player;

    private final Computer computer;

    private final Hint hint;

    private boolean progress;

    public BaseballGame() {
        this.player = new Player();
        this.computer = new Computer();
        this.hint = new Hint();
        this.progress = true;
    }

    public void play() {
        System.out.println(GAME_START_MESSAGE);
        while (progress) {
            startGame();
            this.progress = checkProgress();
        }
    }

    public void startGame() {
        computer.pickRandomNumbers();
        do {
            player.getBaseballInput();
            System.out.println(hint.getBaseballResult(this.player, this.computer));
        } while (!hint.isThreeStrike());
    }

    private Boolean checkProgress() {
        return RESTART.equals(player.getProgressInput());
    }
}
