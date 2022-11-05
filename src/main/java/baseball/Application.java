package baseball;

public class Application {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println(START_SENTENCE);
    }
}