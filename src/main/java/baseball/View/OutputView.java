package baseball.View;

public class OutputView {

    private final String INPUTNUM = "숫자를 입력해주세요 : ";
    private static final String STARTMESSAGE = "숫자 야구 게임을 시작합니다.";

    public void startGameMessage() {
        System.out.println(STARTMESSAGE);
    }

    public void inputNumMessage() {
        System.out.print(INPUTNUM);
    }
}
