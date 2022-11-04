package baseball.view;

public class OutputView {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_NUM = "숫자를 입력해주세요 : ";

    public static void printRequestNum() {
        System.out.print(REQUEST_NUM);
    }

    public static void printGameStart() {
        System.out.println(GAME_START);
    }
}
