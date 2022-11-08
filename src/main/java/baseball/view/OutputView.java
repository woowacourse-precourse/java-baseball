package baseball.view;

public class OutputView {

    private static final String SINGLE_BLANK = " ";

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public void printGameBegin() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Long balls, Long strikes) {
        System.out.println(getResultString(balls, strikes));
    }

    private String getResultString(Long ballCount, Long strikeCount) {
        String ball = ballCount + BALL;
        String strike = strikeCount + STRIKE;
        if (ballCount > 0 && strikeCount > 0) {
            return ball + SINGLE_BLANK + strike;
        }
        if (ballCount > 0) {
            return ball;
        }
        if (strikeCount > 0) {
            return strike;
        }
        return NOTHING;
    }

    public void printGameFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
