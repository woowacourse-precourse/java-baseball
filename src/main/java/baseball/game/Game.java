package baseball.game;

import baseball.util.Utils;

public class Game {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";

    private Player player;
    private Computer computer;
    private Result result;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void start() {
        Utils.announce(GAME_START);
        do {
            play();
        } while (player.wantRestart(Utils.getPlayerInputForRestartGameByConsole()));
    }

    private void play() {
        computer.generateAnswer();
        do {
            player.initMyAnswerBy(Utils.getPlayerInputForGenerateAnswerByConsole());
            result = computer.resultBy(player);
            Utils.announce(result.toString());
        } while (!result.isEnd());
    }
}
