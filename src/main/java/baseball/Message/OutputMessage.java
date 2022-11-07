package baseball.Message;

public class OutputMessage {
    public static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String REQUEST_NUMBER_INPUT_MSG = "숫자를 입력해 주세요 : ";
    public static final String GAME_END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REGAME_SUGGESTION_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static void numberInputMessage(){
        System.out.println(REQUEST_NUMBER_INPUT_MSG);
    }
    public static void retryGameMessage(){
        System.out.println(REGAME_SUGGESTION_MSG);
    }
    public static void printGameStartMessage() {
        System.out.println(GAME_START_MSG);
    }
    public static void printGameSetMessage(){
        System.out.println(GAME_END_MSG);
    }
}
