package baseball;

public class Message {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요. : ";

    public static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아니거나 숫자로만 이루어져 있지 않습니다. 숫자만 입력해주세요.";
    public static final String NOT_THREE_LENGTH_EXCEPTION_MESSAGE = "입력된 수는 3자리가 아닙니다. 3자리로 구성된 수만 입력해주세요.";
    public static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "입력된 수에 중복이 있습니다. 각각 다른 숫자를 입력해주세요.";
    public static final String ZERO_INCLUDED_EXCEPTION_MESSAGE = "입력된 수에 0이 포함되어 있습니다. 0을 제외한 1부터 9 사이의 수를 입력해주세요.";

    public static void printInitialGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputNumbersMessage() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
    }
}
