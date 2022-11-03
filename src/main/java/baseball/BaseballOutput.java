package baseball;

public class BaseballOutput {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_PLAY_CODE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printInputPlayCodeMessage() {
        System.out.println(INPUT_PLAY_CODE_MESSAGE);
    }

    public void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }
}
