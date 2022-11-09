package baseball;

public class Application {
    private final static int CONTINUE = 1;

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (game.run() == CONTINUE) {
        }
    }
}
