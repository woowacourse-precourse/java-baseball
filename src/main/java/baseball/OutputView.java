package baseball;

public class OutputView {
    private static final String GAME_START_STR = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_HINT_STR = "숫자를 입력해주세요 : ";

    public void printGameStart() {
        System.out.println(GAME_START_STR);
    }

    public void printInputHint() {
        System.out.print(INPUT_HINT_STR);
    }
}
