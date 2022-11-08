package baseball;

public class View {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String PLAYER_INPUT = "숫자를 입력해주세요 : ";
    private static final String RESULT_BALL = ResultType.BALL.getResult();
    private static final String RESULT_STRIKE = ResultType.STRIKE.getResult();
    private static final String RESULT_NOTHING = ResultType.NOTHING.getResult();
    private static final String CORRECT = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static Integer initValue;
    private final int digit;

    private static class ViewHolder {
        private static final View INSTANCE = new View(initValue);
    }

    private View(int digit) {
        this.digit = digit;
    }

    public static View getInstance(int digit) {
        View.initValue = digit;
        View instance = ViewHolder.INSTANCE;
        View.initValue = null;
        return instance;
    }

    public void printStart() {
        System.out.println(GAME_START);
    }

    public void printPlayerTurn() {
        System.out.print(PLAYER_INPUT);
    }

    public void printNoting() {
        System.out.println(RESULT_NOTHING);
    }

    public void printCorrect() {
        StringBuilder correctMsg = new StringBuilder();

        correctMsg.append(digit).append(RESULT_STRIKE).append(LINE_SEPARATOR)
                  .append(digit).append(CORRECT).append(LINE_SEPARATOR)
                  .append(GAME_RESTART);

        System.out.println(correctMsg);
    }

    public void printBallAndStrike(int countOfBall, int countOfStrike) {
        if (countOfBall != 0 && countOfStrike != 0) {
            System.out.printf("%d%s %d%s%s", countOfBall, RESULT_BALL, countOfStrike, RESULT_STRIKE, LINE_SEPARATOR);
            return;
        }

        if (countOfBall != 0) {
            System.out.printf("%d%s%s", countOfBall, RESULT_BALL, LINE_SEPARATOR);
            return;
        }

        System.out.printf("%d%s%s", countOfStrike, RESULT_STRIKE, LINE_SEPARATOR);
    }

}
