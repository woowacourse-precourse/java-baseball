package baseball;

public class BaseballGame {

    public static void execute() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
    }

    private void start() {
        Printer.start();

        boolean isPlaying = false;

        while (isPlaying) {
            isPlaying = this.play();
        }

        Printer.finish();
    }

    private boolean play() {
        return false;
    }

}
