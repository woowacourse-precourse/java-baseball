package baseball;

public class GameString {
    private static final String START_COMMENT = "숫자 야구 게임을 시작합니다.";

    private static final String INPUT_COMMENT = "숫자를 입력해주세요 :";

    private static final String CORRECT_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String RESTART_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String BALL_COMMENT = "볼";

    private static final String STRIKE_COMMENT = "스트라이크";

    private static final String NON_CORRECT = "낫싱";

    public static String getStartComment() {
        return START_COMMENT;
    }

    public static String getCorrectComment() {
        return CORRECT_COMMENT;
    }

    public static String getInputComment() {
        return INPUT_COMMENT;
    }


    public static String getRestartComment() {
        return RESTART_COMMENT;
    }

    public String getPlayingString(int numberOfStrike, int numberOfBall){
        String resultString = "";
        if (numberOfBall > 0) {
            resultString += numberOfBall + BALL_COMMENT;
        }
        if (numberOfStrike > 0) {
            if (numberOfBall > 0)
                resultString += " ";
            resultString += numberOfStrike + STRIKE_COMMENT;
        }
        if (numberOfBall == 0 && numberOfStrike == 0){
            resultString = NON_CORRECT;
        }
        return resultString;
    }

}
