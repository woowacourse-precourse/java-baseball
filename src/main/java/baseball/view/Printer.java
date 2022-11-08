package baseball.view;
public class Printer {
    private static final String messageStartGame = "숫자 야구 게임을 시작합니다.";
    private static final String requestInput = "숫자를 입력해주세요 : ";
    private static final String messageBall = "볼 ";
    private static final String messageStrike = "스트라이크";
    private static final String messageNothing = "낫싱";
    private static final String messageClear = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String messageGameEnd = "게임 종료";
    private static final String messageShutDownCheck = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void showRequestInput() {
        System.out.print(requestInput);
    }

    public static void showMessageStartGame() {
        System.out.println(messageStartGame);
    }

    public static void showClear() {
        System.out.println(messageClear);
    }

    public static void showShutDownCheck() {
        System.out.println(messageShutDownCheck);
    }

    public static void showGameEnd() {
        System.out.println(messageGameEnd);
    }
}
