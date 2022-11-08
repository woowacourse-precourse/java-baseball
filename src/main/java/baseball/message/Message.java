package baseball.message;

public class Message {

    public static final String MESSAGE_FOR_START = "숫자 야구 게임을 시작합니다.";
    public static final String MESSAGE_FOR_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MESSAGE_FOR_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_MESSAGE_FOR_PLAYER_NUMBERS = "숫자를 입력해주세요 : ";

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printLineMessage(String message) {
        System.out.println(message);
    }
}
