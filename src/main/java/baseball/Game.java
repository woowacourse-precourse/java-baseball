package baseball;

public class Game {
    private Player player;
    private Computer computer;
    private Result result;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void start() {
        do {
            play();
        } while (player.wantRestart(Utils.getPlayerInputForRestartGameByConsole()));
    }

    private void play() {
        computer.generateAnswer();
        do {
            player.initMyAnswerBy(Utils.getPlayerInputForGenerateAnswerByConsole());
            result = computer.resultBy(player);
            Utils.announce(result);
        } while (!result.isEnd());
    }
}
