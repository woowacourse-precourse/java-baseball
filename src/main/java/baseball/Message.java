package baseball;

public class Message {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요. : ";

    public static void printInitialGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputNumbersMessage() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
    }
}
