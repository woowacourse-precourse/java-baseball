package baseball;

public class BaseballGame {

    private static final Integer RESTART = 1;
    private static final Integer EXIT = 2;

    private static Player player;

    private static Computer computer;

    private static Hint hint;

    private static boolean progress;

    private static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        this.progress = true;
        printStartMessage();
        while (progress) {
            setGame();
        }
    }

    private void setGame() {
        this.computer = new Computer();
        this.player = new Player();
        this.hint = new Hint();
    }
}
