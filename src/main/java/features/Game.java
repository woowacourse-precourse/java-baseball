package features;


public class Game{

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER = "게임을 재시작하려면 1, 종료하려면 2를 입력해주세요.";
    private static final String STRIKE = "3스트라이크";

    private AppConfig game;

    public Game(AppConfig game) {
        this.game = game;
    }


}
