package baseball.game;

public class BaseballGameLauncher {

    public final static String GAME_LAUNCHER_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String GAME_LAUNCHER_CLOSE_MESSAGE = "게임을 완전히 종료합니다.";
    public final static String GAME_RESTART_SELECTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private BaseballGame baseballGame = new BaseballGame();

    public void run() {
        System.out.println(GAME_LAUNCHER_START_MESSAGE);
        startGame();
        System.out.println(GAME_LAUNCHER_CLOSE_MESSAGE);
    }

    private void startGame() {
        do {
            baseballGame.start();
            System.out.println(GAME_CLEAR_MESSAGE);
            System.out.println(GAME_RESTART_SELECTION_MESSAGE);
        } while (baseballGame.isRestart());
    }
}
