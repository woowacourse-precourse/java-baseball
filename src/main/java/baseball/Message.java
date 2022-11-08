package baseball;

public class Message {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요. : ";

    public static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아니거나 숫자로만 이루어져 있지 않습니다. 숫자만 입력해주세요.";
    public static final String NOT_THREE_LENGTH_EXCEPTION_MESSAGE = "입력된 수는 3자리가 아닙니다. 3자리로 구성된 수만 입력해주세요.";
    public static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "입력된 수에 중복이 있습니다. 각각 다른 숫자를 입력해주세요.";
    public static final String ZERO_INCLUDED_EXCEPTION_MESSAGE = "입력된 수에 0이 포함되어 있습니다. 0을 제외한 1부터 9 사이의 수를 입력해주세요.";

    public static final String STRIKE_MESSAGE = "스트라이크 ";
    public static final String BALL_MESSAGE = "볼 ";
    public static final String NOTHING_MESSAGE = "낫싱 ";

    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printInitialGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputNumbersMessage() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
    }

    public static void printStrikeMessage() {
        System.out.print(STRIKE_MESSAGE);
    }

    public static void printBallMessage() {
        System.out.print(BALL_MESSAGE);
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
