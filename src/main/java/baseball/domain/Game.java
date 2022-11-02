package baseball.domain;

public class Game {
    private static String START_GAME = "숫자 야구 게임을 시작합니다.";

    public void Start() {
        while (true) {
            System.out.println(START_GAME);
        }
    }
}
