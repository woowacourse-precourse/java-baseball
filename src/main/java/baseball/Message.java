package baseball;

public class Message {
    private static final String startMessage = "숫자 야구게임을 시작합니다.";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String inputMessage = "숫자를 입력해주세요: ";
    private static final String nothingCaseMessage = "낫싱";
    private static final String ballCaseMessage = "%d볼";
    private static final String strikeCaseMessage = "%d스트라이크";
    private static final String newline = "\n";
    private static final String finishMessage = "게임 종료";

    public Message() {
    }

    public static void printStartMessage() {
        System.out.println(startMessage);
    }

    public static void printInputMessage() {
        System.out.print(inputMessage);
    }

    public static void printResultMessage(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            System.out.println(nothingCaseMessage);
        } else if (strike == 0) {
            System.out.printf(ballCaseMessage + newline, ball);
        } else if (ball == 0) {
            System.out.printf(strikeCaseMessage + newline, strike);
        } else {
            System.out.printf(ballCaseMessage +" "+ strikeCaseMessage + newline, ball, strike);
        }
    }

    public static void printRestartMessage() {
        System.out.println(restartMessage);
    }

    public static void printFinishMessage() {
        System.out.println(finishMessage);
    }
}
