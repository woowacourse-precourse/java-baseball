package baseball;

public class Result {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public Result() {
    }

    /* 상황별 필요한 메세지 리스트 */
    static void printStartBaseballGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void printEnterNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    static void printStrikeBallMessage(int strike, int ball) {
        if(strike == 3) {
            System.out.println(strike + STRIKE);
            printGameOverMessage();
        }
        if(strike > 0 && ball > 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        if(strike > 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        }
        if(strike == 0 && ball > 0) {
            System.out.println(ball + BALL);
        }
        if(strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        }
    }

    static void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static void printStartNewGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
