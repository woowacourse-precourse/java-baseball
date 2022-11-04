package baseball;

public class Game {
    public final static String START_NOTIFICATION = "숫자 야구 게임을 시작합니다.";
    public final static String END_NOTIFICATION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void start() {
        System.out.println(START_NOTIFICATION);
    }
}
