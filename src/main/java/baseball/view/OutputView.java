package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ANSWER_INPUT_GUIDE = "숫자를 입력해주세요 : ";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printAnswerInputGuide() {
        System.out.println(ANSWER_INPUT_GUIDE);
    }
}
