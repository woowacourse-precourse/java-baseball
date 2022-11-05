package baseball;

public class BaseballService {
    BaseballBot baseballBot;
    Player player = new Player();

    public void initGame() {
        System.out.println("숫자 야구 게임을 시작합니다 start");
        baseballBot = new BaseballBot();
        baseballBot.createRandomValue();

    }

    public void startGame() {
        initGame();

        do {
            takeTurn();

            if (baseballBot.isEnd() && wantRestart()) {
                startGame();
            }

        } while (!baseballBot.isEnd());
    }

    private void takeTurn() {
        String input = player.getInput();
        String hintStr = baseballBot.checkHint(input);
        System.out.println(hintStr);
    }

    private boolean wantRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.restart");
        return player.checkRestart();
    }
}
