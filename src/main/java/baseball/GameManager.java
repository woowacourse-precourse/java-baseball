package baseball;

public class GameManager {

    public static int ball;
    public static int strike;
    public static boolean isNothing;

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String STOP_REPEAT_INPUT_STATUS = "2";
    private static final String ASK_PREDICT_INPUT = "숫자를 입력해주세요 : ";
    private static final String ASK_REPEAT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";


    public GameManager() {
        System.out.println(START_MESSAGE);
    }

    public static void playGame() {
        while (true) {
            play();

            System.out.println(ASK_REPEAT);
            String repeatInput = UserManager.getRepeatInput();
            if (repeatInput.compareTo(STOP_REPEAT_INPUT_STATUS) == 0) {
                break;
            }
        }
    }

    public static void play() {
        NumberManager.setAnswer();

        while (true) {
            System.out.print(ASK_PREDICT_INPUT);
            String predictInput = UserManager.getPredictInput();

            if (NumberManager.isAnswer(predictInput)) {
                System.out.println(END_MESSAGE);
                break;
            } else {
                NumberManager.getHint(predictInput);
                System.out.println(getHintString());
            }
        }
    }

    public static String getHintString() {
        String hint = "";
        if (isNothing) {
            hint += NOTHING;
        }
        if (ball != 0) {
            hint += ball + BALL + " ";
        }
        if (strike != 0) {
            hint += strike + STRIKE;
        }
        return hint;
    }

}
