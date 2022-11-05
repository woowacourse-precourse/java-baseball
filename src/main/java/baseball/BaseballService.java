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

        } while (!baseballBot.isEnd());
    }

    private void takeTurn() {
        String input = player.getInput();
        String hintStr = baseballBot.checkHint(input);
        System.out.println(hintStr);
    }
}
