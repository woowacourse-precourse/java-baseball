package baseball;

public class Application {
    private final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static void main(String[] args) {
        Game baseballGame = new Game();
        System.out.println(START_MESSAGE);
        baseballGame.start();
    }
}
