package baseball;

public class OutputPrint {
    public static final String START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_REQUEST = "숫자를 입력해주세요 : ";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String INPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final int STRIKE_INDEX = 0;
    public static final int BALL_INDEX = 1;

    public void printStart() {
        System.out.println(START);
    }

    public void printRequest() {
        System.out.print(INPUT_REQUEST);
    }

    public void printGameResult(int[] processedData) {
        if (processedData[STRIKE_INDEX] + processedData[BALL_INDEX] == 0) {
            System.out.printf("%s\n", NOTHING);
        }
        if (processedData[BALL_INDEX] > 0 && processedData[STRIKE_INDEX] == 0) {
            System.out.printf("%d%s\n", processedData[BALL_INDEX], BALL);
        }
        if (processedData[STRIKE_INDEX] > 0 && processedData[BALL_INDEX] == 0) {
            System.out.printf("%d%s\n", processedData[STRIKE_INDEX], STRIKE);
        }
        if (processedData[STRIKE_INDEX] > 0 && processedData[BALL_INDEX] > 0) {
            System.out.printf("%d%s %d%s\n", processedData[BALL_INDEX], BALL, processedData[STRIKE_INDEX], STRIKE);
        }
    }

    public void printWin() {
        System.out.println(WIN);
    }

    public void printRestart() {
        System.out.println(INPUT_RESTART);
    }
}
