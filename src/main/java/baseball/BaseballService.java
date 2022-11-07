package baseball;

public class BaseballService {
    public static final String GAME_START_STR = "숫자 야구 게임을 시작합니다";
    public static final String GAME_RESTART_STR = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    BaseballBot baseballBot;
    Player player = new Player();

    public void initGame() {
        System.out.println(GAME_START_STR);
        baseballBot = new BaseballBot();
        baseballBot.createRandomValue();

    }

    public void startGame() {
        initGame();

        do {
            takeTurn();

            if (baseballBot.isGameEnd() && wantRestart()) {
                startGame();
            }

        } while (!baseballBot.isGameEnd());
    }

    private void takeTurn() {
        String input = player.getInput();
        String hintStr = baseballBot.checkHint(input);
        System.out.println(hintStr);
    }

    private boolean wantRestart() {
        System.out.println(GAME_RESTART_STR);
        return player.checkRestart();
    }
}
