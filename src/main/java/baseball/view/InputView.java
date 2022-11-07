package baseball.view;

public class InputView {

    private static final String GAME_STRART_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETRY_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void printGameStart(){
        System.out.printf(GAME_STRART_MESSAGE+"\n");
    }
    public static void printAskReStart(){
        System.out.printf(RETRY_GAME_MESSAGE+"\n");
    }
    public static void printInputNumber(){
        System.out.printf(INPUT_NUMBER_MESSAGE);
    }
}
