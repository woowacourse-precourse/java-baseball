package baseball.config;

public class PrintOutput {
    private static final String START_ORDER = "숫자 야구 게임을 시작합니다.";
    private static final String ERROR_ORDER = "잘못된 입력입니다. 프로그램을 종료합니다.";
    private static final String FINISH_ORDER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_FINISH = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startOrder() {
        System.out.println(START_ORDER);
    }

    public static void errorOrder() {
        System.out.println(ERROR_ORDER);
    }

    public static void finishOrder() {
        System.out.println(FINISH_ORDER);
        System.out.println(RESTART_OR_FINISH);
    }
}
