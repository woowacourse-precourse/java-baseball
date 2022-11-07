package baseball;

public class Application {
    public static void main(String[] args) {
        final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

        System.out.println(START_MESSAGE);
        Game.run();
    }
}
