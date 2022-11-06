package baseball.view;

public class InputView {
    private String GAMESTART = "숫자 야구 게임을 시작합니다.";
    private String INPUT_USERNUM = "숫자를 입력해주세요 : ";

    public void GameStart() {
        System.out.println(GAMESTART);
    }

    public void InputUserNum() {
        System.out.println(INPUT_USERNUM);
    }

}
